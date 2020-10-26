import merge from 'lodash.merge';
import GraphQLJSON from 'graphql-type-json';
import { makeExecutableSchema } from 'graphql-tools';

import { mergeSchemas } from './utilities';

import {
	classificationMutations,
	classificationQueries,
	classificationTypeDef
} from './level/classification/typeDefs';

import {
	progressMutations,
	progressQueries,
	progressTypeDef
} from './level/progress/typeDefs';

import classificationResolvers from './level/classification/resolvers';
import progressResolvers from './level/progress/resolvers';

// merge the typeDefs
const mergedTypeDefs = mergeSchemas(
	[
		'scalar JSON',
		classificationTypeDef,
		progressTypeDef
	],
	[
		classificationQueries,
		progressQueries
	],
	[
		classificationMutations,
		progressMutations
	]
);

// Generate the schema object from your types definition.
export default makeExecutableSchema({
	typeDefs: mergedTypeDefs,
	resolvers: merge(
		{ JSON: GraphQLJSON }, // allows scalar JSON
		classificationResolvers,
		progressResolvers
	)
});
