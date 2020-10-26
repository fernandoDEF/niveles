export const progressTypeDef = `
  type Progress {
      id: Int!
      type: String!
      name: String!
      advance: Float!
      enable: Boolean!
  }
  input ProgressInput {
      type: String!
      name: String!
      advance: Float!
      enable: Boolean!
  }`;

export const progressQueries = `
      allProgress: [Progress]!
      progressById(id: Int!): Progress!
  `;

export const progressMutations = `
    createProgress(progress: ProgressInput!): Progress!
    updateProgress(id: Int!, progress: ProgressInput!): Progress!
    deleteProgress(id: Int!): Int
`;