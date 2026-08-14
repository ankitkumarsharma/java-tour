# Steps for create basic store

1. Create new project 
2. add database & hibernate configuration setup in application.yaml
3. add dotenv library from mvn repository and create .env file and add all imp credentials and add it in main class server for run global.
4. create Entity Package. Now create OrderItem, Orders and Product Class for Entity
5. create repositories interface for each class
6. create each controller and then create service, then inject that particular service method in related method of controller.
7. that service also inject related repository and related method