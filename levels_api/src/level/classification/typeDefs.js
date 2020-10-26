export const classificationTypeDef = `
  type Classification {
      id: Int!
      level: String!
      type: String!
  }
  input ClassificationInput {
      level: String!
      type: String!
  }`;

export const classificationQueries = `
      allClassification: [Classification]
      classificationById(id: Int!): Classification!
  `;

export const classificationMutations = `
    createClassification(classification: ClassificationInput!): Classification!
    updateClassification(id: Int!, classification: ClassificationInput!): Classification!
    deleteClassification(id: Int!): Int
`;
