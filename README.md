# Gotowy projekt z Labów z Javy

Przy tworzeniu projektu trzeba wybrać:
1. create new project
2. spring boot
3. lang: java; type: maven
4. group: pl.wrona.northwind
5. artifact: customer-validator
6. pl.wrona.northwind.customervalidator
7. jdk: termurin-17; java: 17
8. next
9.  developer tools -> lombok
10. sql -> jdbc api
11. sql -> ms sql server driver (postgreSQL is case of )
12. web -> spring web
    project created
12. modify pom.xml: spring-boot-starter-web -> spring-boot-starter
13. add to pom.xml:
    <dependency>
        <groupId>com.zaxxer</groupId>
        <artifactId>HikariCP</artifactId>
        <version>6.3.0</version>
    </dependency>
14. check whether project compiles (mvn clean install); if not then ¯\_(ツ)_/¯
15. database -> plusik -> data source -> ms sql
16. user & password same as in ms sql server management studio(u: sa, p: SAstudent1); instance same as in sql server studio (DESKTOP-BK5VIEE); host: localhost; port: 1433 (eventually 1434);
17. add to url: ';database=NORTHWND'
    database visible in database section
17. test

Aby uruchomić projekt trzeba zmienić w:
```Java
public HikariConfig dataBaseConfig()
    {
        HikariConfig conifig = new HikariConfig();
        conifig.setJdbcUrl("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;encrypt=true;trustServerCertificate=true;database=NORTHWND");
        conifig.setUsername("sa");
        conifig.setPassword("wasze_haslo");
        // i driver do polaczen
        return conifig;
    }
```

wasze_haslo na wasze hasło.
Reszta powinna działać.
W razie co należy sprawdzić:

| Version                 | Path                                             |
|-------------------------|--------------------------------------------------|
| SQL Server 2022 (16.x) | C:\Windows\SysWOW64\SQLServerManager16.msc      |
| SQL Server 2019 (15.x) | C:\Windows\SysWOW64\SQLServerManager15.msc      |
| SQL Server 2017 (14.x) | C:\Windows\SysWOW64\SQLServerManager14.msc      |
| SQL Server 2016 (13.x) | C:\Windows\SysWOW64\SQLServerManager13.msc      |
| SQL Server 2014 (12.x) | C:\Windows\SysWOW64\SQLServerManager12.msc      |
| SQL Server 2012 (11.x) | C:\Windows\SysWOW64\SQLServerManager11.msc      |

Czy po uruchomieniu odpowiedniej komendy z powyższej tabeli (dla odpowiedniej wersji SQL Server) czy w Network Configuration TCP/IP jest enabled. Powinno dzialać na porcie 1433.

