create table pais(
    Code char(3) not null,
    Name char(52) not null,
    Continent char(100) not null default 'Asia',
    Region char(26) not null,
    Population int(11) not null default 0,
    Capital int(11) default null,
    primary key(Code)
);

insert into pais(code,name,continent,region,population,capital) 
values('ABW','Aruba','North America','Caribbean',103000,129);

insert into pais(code,name,region,population,capital) 
values('AFG','Afghanistan','Southern and central Asia',22342342,1);

insert into pais(code,name,continent,region,population,capital) 
values('AGO','Angola','Africa','Central africa',23452345,56);
