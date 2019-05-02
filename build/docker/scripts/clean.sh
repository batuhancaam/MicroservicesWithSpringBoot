echo "Stopping all containers"
docker-compose stop

echo "Removing all containers"
docker rm $(docker ps -a -q)

echo "Removing all volumes"

docker volume prune

echo "Removing all network "

docker network prune

echo "Removing all image"

docker image prune
