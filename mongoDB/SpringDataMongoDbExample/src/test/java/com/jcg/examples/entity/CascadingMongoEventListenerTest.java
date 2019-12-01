	package com.jcg.examples.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations = {"classpath:applcationContext-tests.xml"})
	public class CascadingMongoEventListenerTest {

	  @Autowired
	  private MongoOperations mongoOperations;

	  /**
	  * Clean collections before tests are executed
	  */
	  @Before
	  public void cleanCollections() {
	      mongoOperations.dropCollection(User.class);
	      mongoOperations.dropCollection(Address.class);
	  }

	  @Test
	  public void testCascadeSave() {
	      // given
	      User user = new User("John Smith");
	      user.setAddress(new Address("London"));

	      // when
	      mongoOperations.save(user);

	      // then
	      List<User> users = mongoOperations.findAll(User.class);
	      assertThat(users).hasSize(1).containsOnly(user);

	      User savedUser = users.get(0);
	      assertThat(savedUser.getAddress()).isNotNull().isEqualTo(user.getAddress());

	      List<Address> addresses = mongoOperations.findAll(Address.class);
	      assertThat(addresses).hasSize(1).containsOnly(user.getAddress());
	  }
	}