create table book_list(
	id uuid not null
		constraint book_list_pkey
			primary key,
	name text not null,
	author text not null,
	year integer
);

create unique index book_list_id_uindex on book_list (id);

create table bookmarks(
	id uuid not null
		constraint bookmarks_pkey
			primary key,
	user_id uuid,
	book_id uuid,
	date_create bigint not null,
	date_delete bigint
);

create table user_session(
	id uuid not null
		constraint user_session_pkey
			primary key,
	date_auto bigint,
	user_id uuid
);

create table users(
	id uuid not null
		constraint users_pkey
			primary key,
	login text not null,
	password text not null,
	email text not null
);

create unique index users_login_uindex on users (login);

create table user_roles(
	id uuid not null
		constraint user_roles_pkey
			primary key,
	users_id uuid not null,
	role_id integer not null
);

create unique index user_roles_id_uindex on user_roles (id);

create unique index user_roles_users_id_uindex on user_roles (users_id);

