# Steps 
REST API, persistance and messaging template steps. 


```sh
# disable k3s
sudo systemctl stop k3s.service
sudo systemctl disable k3s.service

# disable jenkins 
sudo systemctl stop jenkins
sudo systemctl disable jenkins

# run example
sh 01_setup.sh
cd rest-server 
sh run.sh
cd ../consumer
sh run.sh
cd ..
```

# Tests

```
# create resources

#RESTAURANTES

curl -X POST -H 'Content-Type:application/json' localhost:8080/criaRestaurante --data '{"nome":"r2", "morada":"m1", "codigoPostal":"8990-899"}'


#CRIAR/MENU
curl -X POST -H 'Content-Type: application/json' localhost:8080/criaMenu/Entradas --data '{"nome":"Menu","descricao":" ...","opcaoMenu":[{"arroz":"arroz de pato", "feijao":"feijao preto"}]}'

#ENCOMENDAS
curl -X POST -H 'Content-Type: application/json' localhost:8080/criaEncomenda/Entradas --data '["Menu "]'


# get resources contents

#VER/MENU
curl localhost:8080/listaRestaurantes

#VER/ENCOMENDAS
curl localhost:8080/listarEncomenda/1

#VER/HISTORICO
curl localhost:8080/historicoEncomenda

#ENCOMENDA/ALERTA
curl -X POST localhost:8080/Encomenda/1


```

# Cleanup 
```sh
docker stop consumer-container rest-server-container activemq-server-container \
  kafka-server zookeeper-server postgres-server
```
