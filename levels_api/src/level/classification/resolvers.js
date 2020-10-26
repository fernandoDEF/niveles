import { generalRequest, getRequest } from '../../utilities';
import { url, port, entryPoint } from './server';

const URL = `http://${url}:${port}/${entryPoint}`;

const resolvers = {
	Query: {
		allClassification: (_) =>
			//getRequest(URL, ''),
			getRequest(`${URL}/allClassification`, ''),
		classificationById: (_, { id }) =>
			generalRequest(`${URL}/${id}`, 'GET'),
	},
	Mutation: {
		createClassification: (_, { classification }) =>
			generalRequest(`${URL}/`, 'POST', classification),
		updateClassification: (_, { id, classification }) =>
			generalRequest(`${URL}/${id}`, 'PUT', classification),
		deleteClassification: (_, { id }) =>
			generalRequest(`${URL}/${id}`, 'DELETE')
	}
};

export default resolvers;
