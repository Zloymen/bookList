$.ajax({data:{  login: 'zloy',  password: 'abc125'},
            type: 'POST',
            url: '/login'

        }).done(function(data, textStatus, jqXHR) {
            console.log(data, textStatus);

        }).fail(function(jqXHR, textStatus, errorThrown) {
            console.log(data, textStatus);
        });



create table book_list(
	id uuid not null
		constraint book_list_pkey
			primary key,
	name text not null,
	author text not null,
	year integer,
	file_id text
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

create table active_session (
	series_id text NOT NULL constraint active_session_pkey
			primary key,
    user_id uuid NOT NULL,

    token text NOT NULL,
    last_used BIGINT NOT NULL
);

create unique index active_session_series_id_uindex on active_session (series_id);

create unique index active_session_users_id_uindex on active_session (user_id);

insert into book_list (	id,	name,	author,	file_id)values
	(uuid_generate_v4(), 'Анна Каренина', 'Лев Толстой','27866685.jpg'),
	(uuid_generate_v4(), 'Алхимик', 'Пауло Коэльо','26951280.jpg'),
	(uuid_generate_v4(), 'БДВ, или Большой и Добрый Великан', 'Роальд Даль','1000221984.jpg'),
	(uuid_generate_v4(), 'Белый пик', 'Энтони Хоровитц','1000399534.jpg'),
	(uuid_generate_v4(), 'Благие знамения', 'Терри Пратчетт и Нил Гейман','1012961185.jpg'),
	(uuid_generate_v4(), 'Большие надежды', 'Чарльз Диккенс','1002507944.jpg'),
	(uuid_generate_v4(), 'Бог Мелочей', 'Арундати Рой','1000202659.jpg'),
	(uuid_generate_v4(), 'Божество реки', 'Уилбур Смит','1013008122.jpg'),
	(uuid_generate_v4(), 'В дороге', 'Джек Керуак','1002609272.jpg'),
	(uuid_generate_v4(), 'Под деревом зеленым. Вдали от обезумевшей толпы', 'Харди Томас','1001179204.jpg'),
	(uuid_generate_v4(), 'Ведьмы', 'Роальд Даль','1000561681.jpg'),
	(uuid_generate_v4(), 'Великий Гэтсби', 'Фрэнсис Скотт Фицджеральд','1015321042.jpg'),
	(uuid_generate_v4(), 'Ветер в ивах', 'Кеннет Грэм','1002544636.jpg'),
	(uuid_generate_v4(), 'Вечеринка с ночевкой', 'Жаклин Уилсон','1000359265.jpg'),
	(uuid_generate_v4(), 'Вещие сестрички', 'Терри Пратчетт','1012960717.jpg'),
	(uuid_generate_v4(), 'Вики-Ангел', 'Жаклин Уилсон','1000348427.jpg'),
	(uuid_generate_v4(), 'Винни-Пух и все-все-все', 'Алан Милн','1000170019.jpg'),
	(uuid_generate_v4(), 'Властелин колец', 'Джон Толкин','1001485373.jpg'),
	(uuid_generate_v4(), 'Война и мир.', 'Лев Толстой','1005526061.jpg'),
	(uuid_generate_v4(), 'Война миров', 'Герберт Джордж Уэллс','1001800838.jpg'),
	(uuid_generate_v4(), 'Возвращение в Брайдсхед', 'Ивлин Во','1001036039.jpg'),
	(uuid_generate_v4(), 'Волхв', 'Джон Фаулз','1015720565.jpg'),
	(uuid_generate_v4(), 'Вор Времени', 'Терри Пратчетт','1002032605.jpg'),
	(uuid_generate_v4(), 'Гарри Поттер и Кубок Огня', 'Джоан Кэтлин Роулинг','1013719856.jpg'),
	(uuid_generate_v4(), 'Гарри Поттер и Философский камень', 'Джоан Кэтлин Роулинг','1008845973.jpg'),
	(uuid_generate_v4(), 'Гарри Поттер и Тайная комната', 'Джоан Кэтлин Роулинг','1004491663.jpg'),
	(uuid_generate_v4(), 'Гордость и предубеждение', 'Джейн Остен','1005924963.jpg'),
	(uuid_generate_v4(), 'Горменгаст', 'Мервин Пик','1009199280.jpg'),
	(uuid_generate_v4(), 'Граф Монте-Кристо.', 'Александр Дюма','1001156389.jpg'),
	(uuid_generate_v4(), 'Гроздья гнева', 'Джон Стейнбек','1010907866.jpg'),
	(uuid_generate_v4(), 'Грозовой перевал', 'Эмили Бронте','1002043852.jpg'),
	(uuid_generate_v4(), 'Далекие Шатры.', 'Мэри Маргарет Кей','1001665892.jpg'),
	(uuid_generate_v4(), 'Двойняшки', 'Жаклин Уилсон','1000323266.jpg'),
	(uuid_generate_v4(), 'Девочка-находка', 'Жаклин Уилсон','1000389308.jpg'),
	(uuid_generate_v4(), 'Женщина в белом', '	Уильям Уилки Коллинз','1002703966.jpg'),
	(uuid_generate_v4(), 'Жестокое море', 'Николас Монсаррат','Nikolas_Monsarrat__Zhestokoe_more.jpg'),
	(uuid_generate_v4(), 'Заклинатель лошадей', 'Николас Эванс','1003568351.jpg'),
	(uuid_generate_v4(), 'Зеленая миля', 'Стивен Кинг','1005473146.jpg'),
	(uuid_generate_v4(), 'Имя розы', 'Умберто Эко','1015939618.jpg'),
	(uuid_generate_v4(), 'Каин и Авель', 'Джеффри Арчер','1000736217.jpg'),
	(uuid_generate_v4(), 'Ким', ' Редьярд Киплинг','1000716883.jpg'),
	(uuid_generate_v4(), 'Клан Пещерного Медведя', 'Джин М. Ауэл','1004499088.jpg'),
	(uuid_generate_v4(), 'Стража! Стража! К оружию! К оружию!', 'Терри Пратчетт','1011420912.jpg'),
	(uuid_generate_v4(), 'Корабельные новости', 'Энни Прул','1000209299.jpg'),
	(uuid_generate_v4(), 'Крестный отец', 'Марио Пьюзо','1008318883.jpg'),
	(uuid_generate_v4(), 'Леди Кэтрин', 'Ани Сэтон','1005866514.jpg'),
	(uuid_generate_v4(), 'Лола Роза', 'Жаклин Уилсон','1000315289.jpg'),
	(uuid_generate_v4(), 'Лолита', 'Владимир Набоков','1010620572.jpg'),
	(uuid_generate_v4(), 'Любовь во время чумы', 'Габриэль Гарсиа Маркес','1002988077.jpg'),
	(uuid_generate_v4(), 'Маленькие женщины', 'Луиза Мэй Олкотт','1001711987.jpg'),
	(uuid_generate_v4(), 'Мастер и Маргарита', 'Михаил Булгаков','1005610796.jpg'),
	(uuid_generate_v4(), 'Маленький принц', 'Антуан де Сент-Экзюпери','1012966643.jpg'),
	(uuid_generate_v4(), 'Над пропастью во ржи', 'Джером Дэвид Сэлинджер','1012141745.jpg'),
	(uuid_generate_v4(), 'На Западном фронте без перемен', 'Эрих Мария Ремарк','1013000054.jpg'),
	(uuid_generate_v4(), 'Ночная Стража', 'Терри Пратчетт','1016315588.jpg'),
	(uuid_generate_v4(), 'Обитатели Холмов', 'Ричард Адамс','1004516777.jpg'),
	(uuid_generate_v4(), 'Оно', 'Стивен Кинг','1003145139.jpg'),
	(uuid_generate_v4(), 'Осиная Фабрика', 'Иэн Бэнкс','1000720661.jpg'),
	(uuid_generate_v4(), 'Остров Сокровищ', 'Роберт Льюис Стивенсон','1001361290.jpg'),
	(uuid_generate_v4(), 'Парфюмер. История одного убийцы', 'Патрик Зюскинд','1007153723.jpg'),
	(uuid_generate_v4(), 'Плохие девчонки', 'Жаклин Уилсон','1000202663.jpg'),
	(uuid_generate_v4(), 'Горькая радость', 'Колин Маккалоу','1011043262.jpg'),
	(uuid_generate_v4(), 'Я захватываю замок', 'Доди Смит','1007034619.jpg'),
	(uuid_generate_v4(), 'Эмма', 'Джейн Остен','1002442796.jpg'),
	(uuid_generate_v4(), 'Чужестранка.', 'Диана Гэблдон','1015471155.jpg'),
	(uuid_generate_v4(), 'Ученик чародея', 'Раймонд Фейст','1000027985.jpg'),
	(uuid_generate_v4(), 'Цвет волшебства', 'Терри Пратчетт','1013159044.jpg'),
	(uuid_generate_v4(), 'Хайди', 'Иоганна Шпири','1010812430.jpg'),
	(uuid_generate_v4(), 'Франкенштейн', '	Мэри Уолстонкрафт Шелли','1008802911.jpg'),
	(uuid_generate_v4(), 'Фантастический мистер Фокс', 'Роалд Даль','1000108760.jpg'),
	(uuid_generate_v4(), 'Унесенные ветром', 'Маргарет Митчелл','1001541446.jpg'),
	(uuid_generate_v4(), 'Трое в лодке, не считая собаки', 'Джером Клапка Джером','1016114842.jpg'),
	(uuid_generate_v4(), 'Алиса в Стране чудес.', 'Льюис Кэрролл','00371932.jpg');