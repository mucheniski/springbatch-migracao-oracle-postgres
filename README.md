# springbatch-migracao-oracle-postgres  

Overview Spring Batch  
https://giuliana-bezerra.medium.com/spring-batch-para-desenvolvimento-de-jobs-1674ec5b9a20#:~:text=Arquitetura%20Spring%20Batch&text=Um%20job%20no%20Spring%20Batch,que%20possuem%20uma%20l%C3%B3gica%20pr%C3%B3pria.&text=Job%20Repository%3A%20Mant%C3%A9m%20o%20estado,os%20outros%20componentes%20da%20solu%C3%A7%C3%A3o.  

Rodando Docker com Oracle database  
https://www.linkedin.com/pulse/rodando-oracle-database-em-cont%C3%AAineres-docker-manuel-ristoff-tusset/  
https://www.youtube.com/watch?v=X3hx1nJKUuc  

Log into Docker hub (in order to access oracle repository)  
   docker login  

Download image  
   docker pull store/oracle/database-enterprise:12.2.0.1  

Run image  
   docker run -d -p 1521:1521 --name oracledatabase store/oracle/database-enterprise:12.2.0.1  

Connect to container  
   localhost
   port: 1521
   database: ORCLCDB SID
   
Connect to database   
   connect sys as sysdba;  
   password: Oradoc_db1  

Insert the commands  
   alter session set "_ORACLE_SCRIPT"=true;  
   create user developer identified by developer;  
   GRANT ALL PRIVILEGES TO developer;  


Configure Dbeaver Developer  
   Username: developer  
   Password: developer  
   Hostname: localhost  
   Port: 1521  
   Service name: ORCLCDB.localdomain  

![](/img/connection.png)  

Trabalhando com múltiplos datasources  
https://atitudereflexiva.wordpress.com/2020/03/03/spring-batch-trabalhando-com-multiplos-datasources/  

# Postgres  
logar no banco postgres  
~~~
docker exec -it postgresdatabase psql -U developer
~~~  

listar e usar os databases  
~~~
\list  
\connect database_name
~~~
mostrar todos no dbeaver  
On the connection, right-click -> Edit connection -> Connection settings -> on the tabbed panel, select PostgreSQL, check the box Show all databases.  
![](/img/showalldatabasespostgres.png)  

## UML base destino  
![](/img/umldestino.png)