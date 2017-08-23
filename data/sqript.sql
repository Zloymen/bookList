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
