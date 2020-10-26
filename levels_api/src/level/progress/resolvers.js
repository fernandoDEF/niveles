import { generalRequest, getRequest } from '../../utilities';
import { url, port, entryPoint } from './server';

const URL = `http://${url}:${port}/${entryPoint}`;

const resolvers = {
	Query: {
		allProgress: (_) =>
			//getRequest(URL, ''),
			getRequest(`${URL}/allProgress`, ''),
		progressById: (_, { id }) =>
			generalRequest(`${URL}/${id}`, 'GET'),
	},
	Mutation: {
		createProgress: (_, { progress }) =>
			generalRequest(`${URL}/`, 'POST', progress),
		updateProgress: (_, { id, progress }) =>
			generalRequest(`${URL}/${id}`, 'PUT', progress),
		deleteProgress: (_, { id }) =>
			generalRequest(`${URL}/${id}`, 'DELETE')
	}
};

export default resolvers;