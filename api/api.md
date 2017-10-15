### 获取分类信息

http://localhost:5100/api/category/list

GET

#### 请求参数

```json
{
  "machineCode": "123456", //机器码
  "pageSize":"1", //当前页数
  "pageNo":"10" //每页条数
}
```

#### 响应结果

```json
{
  "msg": "success",
  "code": 1,
  "object": [
    {
      "create_time": null,
      "update_time": null,
      "parentId": null,
      "modifier": null,
      "is_del": 0,
      "id": 1,
      "creator": null,
      "categoryName": "蔬菜",
      "sysCompanyId": 1,
      "isValid": 1,
      "modifyDate": null,
      "createDate": null
    },
    {
      "create_time": null,
      "update_time": null,
      "parentId": null,
      "modifier": null,
      "is_del": 0,
      "id": 2,
      "creator": null,
      "categoryName": "海鲜",
      "sysCompanyId": 1,
      "isValid": 1,
      "modifyDate": null,
      "createDate": null
    },
    {
      "create_time": null,
      "update_time": null,
      "parentId": null,
      "modifier": null,
      "is_del": 0,
      "id": 3,
      "creator": null,
      "categoryName": "带皮水果",
      "sysCompanyId": 1,
      "isValid": 1,
      "modifyDate": null,
      "createDate": null
    },
    {
      "create_time": null,
      "update_time": null,
      "parentId": null,
      "modifier": null,
      "is_del": 0,
      "id": 4,
      "creator": null,
      "categoryName": "橘子",
      "sysCompanyId": 1,
      "isValid": 1,
      "modifyDate": null,
      "createDate": null
    }
  ]
}
```