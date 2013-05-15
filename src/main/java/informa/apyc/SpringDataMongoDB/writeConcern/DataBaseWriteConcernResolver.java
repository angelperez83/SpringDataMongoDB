package informa.apyc.SpringDataMongoDB.writeConcern;

import org.springframework.data.mongodb.core.MongoAction;
import org.springframework.data.mongodb.core.WriteConcernResolver;

import com.mongodb.WriteConcern;

public class DataBaseWriteConcernResolver implements WriteConcernResolver {

	@Override
	public WriteConcern resolve(MongoAction action) {

		if ("persona".equals(action.getCollectionName())){
			return WriteConcern.JOURNALED;
		}
		
		return WriteConcern.UNACKNOWLEDGED;
		

	}
	
}
