package mongock.writeConcern.w1.changeLog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;




@ChangeLog
public class ChangeLog1234_Test {
	private static final Logger logger = LoggerFactory.getLogger(ChangeLog1234_Test.class);
	private static final String NAME = "TEST-1";

	@ChangeSet(order = "001", id = NAME, author = "vhanousek")
	public void test1234(MongoTemplate template) {
		logger.warn("Creating collection {}", NAME);
		template.createCollection(NAME);
		logger.warn("Finished ok");
	}

}
