CREATE SEQUENCE email_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE email_verification (
    id BIGINT NOT NULL PRIMARY KEY DEFAULT NEXTVAL('email_seq'),
    email VARCHAR(255) NOT NULL,
    code VARCHAR(20) NOT NULL,
    expiration_time TIMESTAMP NOT NULL
);

-- Optional: Index for faster lookups by email
-- CREATE INDEX idx_email_verification_email ON email_verification(email);
