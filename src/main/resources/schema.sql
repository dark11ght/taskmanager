CREATE DATABASE taskmanager
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE TABLE public.roles
(
    id bigserial,
    role VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX roles_role_uindex ON public.roles (role);

CREATE TABLE public.users
(
    id bigserial PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    second_name varchar(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    role BIGINT DEFAULT 1 NOT NULL,
    sex BIGINT,
    company_id BIGINT NOT NULL,
    specialization_id BIGINT NOT NULL,
    position_id BIGINT NOT NULL,
    notes varchar(255)
);
CREATE UNIQUE INDEX users_email_uindex ON public.users (email);

CREATE TABLE public.companys
(
    id bigserial PRIMARY KEY,
    company_title VARCHAR(255) NOT NULL,
    address varchar(255) NOT NULL,
    company_info VARCHAR(255)
);
CREATE UNIQUE INDEX companys_company_title_uindex ON public.companys (company_title);

CREATE TABLE public.projects
(
    id bigserial PRIMARY KEY,
    object_code VARCHAR(255),
    project_title VARCHAR(255) NOT NULL,
    company_id BIGINT NOT NULL,
    creater_id BIGINT NOT NULL,
    status_project_id bigint NOT NULL,
    object_info VARCHAR(255)
);

ALTER TABLE public.projects ADD create_date date NOT NULL;
ALTER TABLE public.projects ADD start_date date NULL;
ALTER TABLE public.projects ADD finish_date date NULL;
ALTER TABLE public.projects ADD changed_date date NULL;

CREATE TABLE public.project_status
(
    id bigserial PRIMARY KEY,
    project_status VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX project_status_project_status_uindex ON public.project_status (project_status);

CREATE TABLE public.task_status
(
    -- only integer type can be autoincremented, got VARCHAR
id VARCHAR PRIMARY KEY,
    task_status VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX task_status_task_status_uindex ON public.task_status (task_status);

CREATE TABLE public.specialization
(
    id bigserial PRIMARY KEY,
    specialization_title VARCHAR(255) NOT NULL,
    section_id BIGINT NOT NULL
);
CREATE UNIQUE INDEX specialization_specialization_title_uindex ON public.specialization (specialization_title);

CREATE TABLE public.sections
(
    id bigserial PRIMARY KEY,
    section_title VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX sections_section_title_uindex ON public.sections (section_title);

CREATE TABLE public.task_template
(
    id bigserial PRIMARY KEY,
    task_title VARCHAR(255) NOT NULL,
    project_id int NOT NULL,
    section_id BIGINT NOT NULL,
    creator_id bigint NOT NULL,
    status BIGINT NOT NULL,
    task_info varchar(500) NOT NULL,
    task_notes VARCHAR(500),
    create_date date NOT NULL,
    finish_date date NOT NULL,
    start_date date,
    changed_date date,
    close_date date
);

CREATE TABLE public.tasks
(
    id bigserial PRIMARY KEY,
    task_template_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL
);

    id bigserial PRIMARY KEY,
    project_id BIGINT NOT NULL,
    sections_id bigint NOT NULL,
    create_date date NOT NULL,
    close_date date,
    section_status bigint NOT NULL,
    section_info varchar(255)
);