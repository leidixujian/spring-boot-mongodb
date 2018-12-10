/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class SampleMongoApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private BackEndInstanceRepository beRepository;

	@Override
	public void run(String... args) throws Exception {
		this.repository.deleteAll();
		this.beRepository.deleteAll();
		String endpoint = "http://www.exemple.com/endpoint";
		String endpoint1 = endpoint + "1/";
		String endpoint2 = endpoint + "2/";
		String endpoint3 = endpoint + "3/";

		BackEndInstance backEndInstance1 = new BackEndInstance().url(endpoint1);
		BackEndInstance backEndInstance2 = new BackEndInstance().url(endpoint2);

		backEndInstance1= this.beRepository.save(backEndInstance1);
		backEndInstance2= this.beRepository.save(backEndInstance2);


		BackEndLocation backEndLoc1 = new BackEndLocation();
		backEndLoc1.backEndInstance(backEndInstance1);
		BackEndLocation backEndLoc2 = new BackEndLocation();
		backEndLoc2.backEndInstance(backEndInstance2);
		BackEndLocation backEndLoc3 = new BackEndLocation();
		backEndLoc3.setUrl(endpoint3);

		BackEnds backEnds1 = new BackEnds();
		backEnds1.put(UUID.randomUUID().toString(), backEndLoc1);
		backEnds1.put(UUID.randomUUID().toString(), backEndLoc2);
		backEnds1.put(UUID.randomUUID().toString(), backEndLoc3);

		BackEnds backEnds2 = new BackEnds();
		backEnds2.put(UUID.randomUUID().toString(), backEndLoc2);

		// save a couple of customers
		this.repository.save(new Customer("Alice", "Smith", backEnds1));
		this.repository.save(new Customer("Bob", "Smith", backEnds2));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : this.repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : this.repository.findByLastName("Smith")) {
			System.out.println(customer);
		}

		// fetch all backend instances
		System.out.println("BackEndInstance found with findAll():");
		System.out.println("-------------------------------");
		for (BackEndInstance backEndInstance : this.beRepository.findAll()) {
			System.out.println(backEndInstance);
		}
		System.out.println();

		// fetch an individual backend instance
		System.out.println("BackEndInstance found with findByUrl('"+ endpoint1 +"'):");
		System.out.println("--------------------------------");
		System.out.println(this.beRepository.findByUrl(endpoint1));

	}

	public static void main(String[] args) {
		SpringApplication.run(SampleMongoApplication.class, args);
	}

}
