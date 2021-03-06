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

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Data
@Document(collection = "tenant")
public class Customer {

	@Id
	private String id;

	private String firstName;

	private String lastName;

	private BackEnds backEnds;

	public Customer() {
	}

	public Customer(String firstName, String lastName, BackEnds backEnds) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.backEnds = backEnds;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName='%s', lastName='%s', backends='%s']", this.id,
				this.firstName, this.lastName, this.backEnds);
	}

}
