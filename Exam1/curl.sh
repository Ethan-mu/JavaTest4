echo "======用户登录======="
curl http://localhost:18080/login/LINDA/aa

#add
echo "======添加用户======="
result=`curl -H "Content-Type: application/json" -X PUT  --data '{
"firstName":"33333",
"lastName":"3333",
"email":"33333",
"address":"aaaa"
}' http://localhost:18080/add 2>/dev/null|awk -F '[:,]' '{print $7}'`
echo ${result}

#update
echo "======更新用户======="
curl -H "Content-Type: application/json" -X POST  --data '{
"firstName":"444444",
"lastName":"4444",
"email":"444444444",
"address":"aaaa"
}' http://localhost:18080/update/${result}


#delete
echo "======删除用户======="
curl -X DELETE "http://localhost:18080/delete/"+${result}

echo "=====================================film表操作=============================="

echo "==============插入数据======================"
curl -H "Content-Type: application/json" -X PUT  --data '{
"languageId":"1",
"title":"2",
"description":"3"
}' http://localhost:18080/addFilm

echo "==============pagehelper分页======================"
curl http://localhost:18080/queryAll/1/6