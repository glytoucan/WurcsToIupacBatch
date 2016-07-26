create:
	docker-compose -f docker-compose.build.yml rm -f
	docker-compose -f docker-compose.build.yml up
	docker-compose -f docker-compose.package.yml rm -f
	docker-compose -f docker-compose.package.yml up
	echo docker commit iupacbatch_iupac_1 glycoinfo.org:5000/iupac_batch:v${IUPAC_VERSION}
	docker commit iupacbatch_iupac_1 glycoinfo.org:5000/iupac_batch:v${IUPAC_VERSION}
	docker push glycoinfo.org:5000/iupac_batch:v${IUPAC_VERSION}

ls:
	docker run --rm --volumes-from iupacbatch_iupac_1 aokinobu/debian ls -alrt /data/

push:
	docker-compose -f docker-compose.prod.yml push

ps:
	sudo docker ps
