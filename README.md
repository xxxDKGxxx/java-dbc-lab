# Gotowy projekt z Labów z Javy

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

