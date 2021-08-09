# ZsoftBank Backend Application

## Installation

### Involved technologies

![github]
![java]
![springboot]
![maven]
![postgresql]

### Global installation

Make sure to have  jdk and docker  installed on your computer :

```bash
git clone git@github.com:AmineYahouni/ZsoftConsultBank.git
cd ZsoftConsultBank
docker-compose up -d
```

and you're good to go !

### Test of the application

You need a postman client to ask ower API, follow this few steps :
>![info]    bank api is exposed on port <strong>80</strong>

In order to create a user and get his id and accounts please ask api with this path :
>![warning]    this step is required, because at the beginning the database is empty. 
```bash
get http://localhost/api/clientAndAccounts
```

to make a withdrawal you just have to send a <strong>put</strong> request with double amount in body to this path :
```bash
put http://localhost/api/client/{id}/account/{id}/withdrawal
```

to make a deposit you just have to send a put request with double amount in body to this path :  
```bash
put http://localhost/api/client/{id}/account/{id}/deposit
```

To get all transactions of a client: 
```bash
get http://localhost/api/client/{id}/transactions
```


## Contributors

- Amine YAHOUNI<[amineyahouni@gmail.com](mailto://amineyahouni@gmail.com)>




[github]: .README/icons/github.png "gitlab"
[java]: .README/icons/java.png "Java"
[springboot]: .README/icons/springboot-64x64.png "springboot"
[maven]: .README/icons/maven.png "maven"
[postgresql]: .README/icons/postgresql-64x64.png

[info]: .README/info.png
[warning]: .README/warning.png 
