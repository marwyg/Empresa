# Pre-requirements

* Java 13
* MySQL, MariaDB (default config)

# Setup

## Database

`create database empresa;`  

### Create Development User 
`create User 'spring_dev'@'%' identified by 'spring_dev_password';`  
`grant all on empresa.* to 'spring_dev'@'%';`  

### Create Production User  
`create User 'spring_prod'@'%' identified by 'spring_prod_password';`  
`grant select, insert, delete, update on empresa.* to 'spring_prod'@'%';`
