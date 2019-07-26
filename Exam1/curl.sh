 curl http://localhost:8080/login/LINDA/aa

#add
$ result=`curl -H "Content-Type: application/json" -X PUT  --data '{
"firstName":"aa",
"lastName":"bbc",
"email":"123214",
"address":"aaaa"
}' http://localhost:8080/add 2>/dev/null|awk -F '[:,]' '{print $7}'`

#update
curl -H "Content-Type: application/json" -X POST  --data '{
"customerId":""+${result},
"firstName":"aa",
"lastName":"bbc",
"email":"123214",
"address":"aaaa"
}' http://localhost:8080/update

#delete
 curl -X DELETE "http://localhost:8080/delete/"+${result}