CREATE TABLE vocabularies (
                              id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                              question VARCHAR(255) NOT NULL,
                              answer VARCHAR(255) NOT NULL,
                              vocabularyID BIGINT,
                              date TIMESTAMP,
                              errors BIGINT,
                              successes BIGINT
);