## Web-приложение с использованием JavaEE (Servlets) и Hibernate.  
  
В БД реализована связь один ко многим (у одного тренера могут быть несколько атлетов, у атлета - только один тренер).  
В БД реализована связь многие ко многим (у каждого тренера могут быть несколько специализаций, специализация может принадлежать разным тренерам).  
   
В приложении используется стратегия наследования классов Joined.  
Для настройки приложения нужно выполнить скрипты по созданию таблиц в БД:  
  
create table person(  
id SERIAL PRIMARY KEY,  
name VARCHAR(50) NOT NULL,  
surname VARCHAR(50) NOT NULL  
);  
 
create table speciality(  
id SERIAL PRIMARY KEY,  
description VARCHAR(50) not null  
);  
  
create table coach(  
id int not null PRIMARY KEY,  
status int,  
constraint coach_person_pk foreign key (id) references person(id) ON UPDATE CASCADE ON DELETE NO ACTION  
);  
  
create table athlete(  
id int not null PRIMARY KEY,  
coach_id int not null,  
foreign key (coach_id) REFERENCES coach(id) ON UPDATE CASCADE ON DELETE NO ACTION,  
constraint athlete_person_pk foreign key (id) references person(id) ON UPDATE CASCADE ON DELETE NO ACTION  
);  
  
CREATE TABLE coach_speciality (  
coach_id INT REFERENCES coach(id) ON UPDATE CASCADE,  
speciality_id INT REFERENCES speciality(id) ON UPDATE CASCADE,  
CONSTRAINT coach_spec_pkey PRIMARY KEY (coach_id, speciality_id)  
);  
  
Приложение протестировано с использованием сервера apache-tomcat-10.1.25  
Необходимо прописать в hibernate.cfg.xml данные Вашей БД: url, username, password.  
  
PS:   
Все поля форм в браузере требуется заполнять.   
Т.о., на странице обновления сведений о спортсмене /update неизменяемые сведения просто повторить.  
