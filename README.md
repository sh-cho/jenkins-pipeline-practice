# jenkins-pipeline-practice

## Run Jenkins locally

```sh
docker compose up -d
```
Run jenkins on http://localhost:8080

### (Optional) Add deploy key
```sh
$ su - jenkins
jenkins@1af4fe1b1c4c:~$ ssh-keygen
# ...
jenkins@1af4fe1b1c4c:~$ cat .ssh/id_rsa.pub 
ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQC/o2xGkn1kXWGmP6HdizMOGNL24FMfYdTbcwGTOOrt6/us+I634J0Jy+T97i6Eyfts3q6URSE454Xg+XIVXffU41t7ZzPSTjdaMZqAeSIgE1v4GmKHJmUvIy+V/dC2YDKjKMYOP7LvTbeHK6qaCUXPUsbdBSZ0ZO5bPBZV+yvTYYddLfsrZVe76rNBOnoD+8cMuWDfjsJtiPZRaqhThlP19h7Z2su3/FJLpK2sxQLnZobGS39Ebii73Tm10s3qi4T1TNbcv0tZC9al4TMOS8apksp/o9eszr/JCWUiAYm0Z8araqU+x/uVr3nQau0A1Kplj6U+52Z3hq4MMS5/T2EKeAbPSbfiKTIDXlw5ugcUNvVUU3JV2E/vTNwU4zw9LHKbu6qIjrpbmUGQOQmYbTnkem/hyDdFqI1VrEsAcP7TdVd69m/pq/3iGL/0rwB92iqZnanouhia/Xcm0n3jdngUPtGQtwZeu1fAiIfYK0+OexUwpZZu0ngPqmq/k5w8Ft0= jenkins@1af4fe1b1c4c
```
Creating deploy key into `/var/jenkins_home/.ssh`

Add deploy key in GitHub repo settings

Add Credential to Jenkins

### (Optional) test webhook
```sh
ngrok http --domain={YOUR_DOMAIN}.ngrok-free.app 8080 
```
Open endpoint with ngrok

Fill "Configuration - GitHub Project" and check "Build Triggers - GitHub hook trigger for GITScm polling"

### Installed plugins
- docker, docker pipeline
- git parameter
- github integration

## DemoApp for test jenkins

```sh
./gradlew clean
./gradlew bootJar
./gradlew test
```

## Links
- https://github.com/jenkinsci/pipeline-examples
