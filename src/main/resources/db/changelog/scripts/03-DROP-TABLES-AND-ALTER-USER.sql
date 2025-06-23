DROP TABLE IF EXISTS design.user_role;

DROP TABLE IF EXISTS design.role;

ALTER TABLE design.app_user
ADD COLUMN role VARCHAR(20);
