---
title: 苍穹外卖-管理端接口
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.23"

---

# 苍穹外卖-管理端接口

Base URLs:

# Authentication

# 分类相关接口

## PUT 修改分类

PUT /admin/category

> Body 请求参数

```json
{
  "id": 0,
  "name": "string",
  "sort": 0,
  "type": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | CategoryDTO|none|
|» id|body|integer(int64)| 是 ||分类id|
|» name|body|string| 是 ||分类名称|
|» sort|body|integer(int32)| 是 ||排序|
|» type|body|integer(int32)| 是 ||分类类型|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|

## POST 新增分类

POST /admin/category

> Body 请求参数

```json
{
  "id": 0,
  "name": "string",
  "sort": 0,
  "type": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | CategoryDTO|none|
|» id|body|integer(int64)| 否 ||none|
|» name|body|string| 是 ||分类名称|
|» sort|body|integer(int32)| 是 ||排序，按照升序排序|
|» type|body|integer(int32)| 是 ||分类类型：1为菜品分类，2为套餐分类|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|

## DELETE 根据id删除分类

DELETE /admin/category

> Body 请求参数

```
string

```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|query|string| 是 ||分类id|
|body|body|string| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|

## GET 分类分页查询

GET /admin/category/page

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|name|query|string| 否 ||分类名称|
|page|query|string| 是 ||页码|
|pageSize|query|string| 是 ||每页记录数|
|type|query|string| 否 ||分类类型：1为菜品分类，2为套餐分类|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "msg": null,
  "data": {
    "total": 0,
    "records": [
      {
        "id": 0,
        "type": 0,
        "name": "string",
        "sort": 0,
        "status": 0,
        "createTime": "string",
        "updateTime": "string",
        "createUser": 0,
        "updateUser": 0
      }
    ]
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|true|none||none|
|» msg|null|false|none||none|
|» data|object|true|none||none|
|»» total|number|true|none||none|
|»» records|[object]|true|none||none|
|»»» id|number|true|none||none|
|»»» type|number|true|none||none|
|»»» name|string|true|none||none|
|»»» sort|number|true|none||none|
|»»» status|number|true|none||none|
|»»» createTime|string|true|none||none|
|»»» updateTime|string|true|none||none|
|»»» createUser|number|true|none||none|
|»»» updateUser|number|true|none||none|

## POST 启用、禁用分类

POST /admin/category/status/{status}

> Body 请求参数

```json
{}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|status|path|string| 是 ||1为启用，0为禁用|
|id|query|string| 是 ||分类id|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|

## GET 根据类型查询分类

GET /admin/category/list

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|type|query|string| 否 ||分类类型：1为菜品分类，2为套餐分类|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": [
    {
      "createTime": "2019-08-24T14:15:22Z",
      "createUser": 0,
      "id": 0,
      "name": "string",
      "sort": 0,
      "status": 0,
      "type": 0,
      "updateTime": "2019-08-24T14:15:22Z",
      "updateUser": 0
    }
  ],
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«List«Category»»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|[object]|false|none||none|
|»» Category|object|false|none|Category|none|
|»»» createTime|string(date-time)|false|none||none|
|»»» createUser|integer(int64)|false|none||none|
|»»» id|integer(int64)|false|none||none|
|»»» name|string|false|none||none|
|»»» sort|integer(int32)|false|none||none|
|»»» status|integer(int32)|false|none||none|
|»»» type|integer(int32)|false|none||none|
|»»» updateTime|string(date-time)|false|none||none|
|»»» updateUser|integer(int64)|false|none||none|
|» msg|string|false|none||none|

# 员工相关接口

## PUT 修改密码

PUT /admin/employee/editPassword

> Body 请求参数

```json
{
  "empId": 0,
  "newPassword": "string",
  "oldPassword": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | PasswordEditDTO|none|
|» empId|body|integer(int64)| 是 ||员工id|
|» newPassword|body|string| 是 ||新密码|
|» oldPassword|body|string| 是 ||旧密码|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|

## POST 启用、禁用员工账号

POST /admin/employee/status/{status}

> Body 请求参数

```json
{}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|status|path|string| 是 ||状态，1为启用 0为禁用|
|id|query|string| 是 ||员工id|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|

## GET 员工分页查询

GET /admin/employee/page

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|name|query|string| 否 ||员工姓名|
|page|query|string| 是 ||页码|
|pageSize|query|string| 是 ||每页记录数|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "msg": null,
  "data": {
    "total": 0,
    "records": [
      {
        "id": 0,
        "username": "string",
        "name": "string",
        "password": "string",
        "phone": "string",
        "sex": "string",
        "idNumber": "string",
        "status": 0,
        "createTime": "string",
        "updateTime": "string",
        "createUser": 0,
        "updateUser": 0
      }
    ]
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|true|none||none|
|» msg|null|false|none||none|
|» data|object|true|none||none|
|»» total|number|true|none||none|
|»» records|[object]|true|none||none|
|»»» id|number|true|none||none|
|»»» username|string|true|none||none|
|»»» name|string|true|none||none|
|»»» password|string|true|none||none|
|»»» phone|string|true|none||none|
|»»» sex|string|true|none||none|
|»»» idNumber|string|true|none||none|
|»»» status|number|true|none||none|
|»»» createTime|string¦null|true|none||none|
|»»» updateTime|string|true|none||none|
|»»» createUser|number¦null|true|none||none|
|»»» updateUser|number|true|none||none|

## POST 员工登录

POST /admin/employee/login

> Body 请求参数

```json
{
  "password": "string",
  "username": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | EmployeeLoginDTO|none|
|» password|body|string| 是 ||密码|
|» username|body|string| 是 ||用户名|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "name": "string",
    "token": "string",
    "userName": "string"
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«EmployeeLoginVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none|EmployeeLoginVO|员工登录返回的数据格式|
|»» id|integer(int64)|false|none||主键值|
|»» name|string|false|none||姓名|
|»» token|string|false|none||jwt令牌|
|»» userName|string|false|none||用户名|
|» msg|string|false|none||none|

## POST 新增员工

POST /admin/employee

> Body 请求参数

```json
{
  "id": 0,
  "idNumber": "string",
  "name": "string",
  "phone": "string",
  "sex": "string",
  "username": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | EmployeeDTO|none|
|» id|body|integer(int64)| 否 ||员工id|
|» idNumber|body|string| 是 ||身份证|
|» name|body|string| 是 ||姓名|
|» phone|body|string| 是 ||手机号|
|» sex|body|string| 是 ||性别|
|» username|body|string| 是 ||用户名|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## PUT 编辑员工信息

PUT /admin/employee

> Body 请求参数

```json
{
  "id": 0,
  "idNumber": "string",
  "name": "string",
  "phone": "string",
  "sex": "string",
  "username": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | EmployeeDTO|none|
|» id|body|integer(int64)| 是 ||none|
|» idNumber|body|string| 是 ||none|
|» name|body|string| 是 ||none|
|» phone|body|string| 是 ||none|
|» sex|body|string| 是 ||none|
|» username|body|string| 是 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|

## GET 根据id查询员工

GET /admin/employee/{id}

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|path|string| 是 ||员工id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "createTime": "2019-08-24T14:15:22Z",
    "createUser": 0,
    "id": 0,
    "idNumber": "string",
    "name": "string",
    "password": "string",
    "phone": "string",
    "sex": "string",
    "status": 0,
    "updateTime": "2019-08-24T14:15:22Z",
    "updateUser": 0,
    "username": "string"
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«Employee»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none|Employee|none|
|»» createTime|string(date-time)|false|none||none|
|»» createUser|integer(int64)|false|none||none|
|»» id|integer(int64)|false|none||none|
|»» idNumber|string|false|none||none|
|»» name|string|false|none||none|
|»» password|string|false|none||none|
|»» phone|string|false|none||none|
|»» sex|string|false|none||none|
|»» status|integer(int32)|false|none||none|
|»» updateTime|string(date-time)|false|none||none|
|»» updateUser|integer(int64)|false|none||none|
|»» username|string|false|none||none|
|» msg|string|false|none||none|

## POST 退出登录

POST /admin/employee/logout

> Body 请求参数

```json
{}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | empty object|none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|

# 套餐相关接口

## PUT 修改套餐

PUT /admin/setmeal

> Body 请求参数

```json
{
  "categoryId": 0,
  "description": "string",
  "id": 0,
  "image": "string",
  "name": "string",
  "price": 0,
  "setmealDishes": [
    {
      "copies": 0,
      "dishId": 0,
      "id": 0,
      "name": "string",
      "price": 0,
      "setmealId": 0
    }
  ],
  "status": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | SetmealDTO|none|
|» categoryId|body|integer(int64)| 是 ||分类id|
|» description|body|string| 否 ||套餐描述|
|» id|body|integer(int64)| 是 ||套餐id|
|» image|body|string| 是 ||套餐图片路径|
|» name|body|string| 是 ||套餐名称|
|» price|body|number| 是 ||套餐价格|
|» setmealDishes|body|[object]| 是 ||套餐和菜品关联关系|
|»» SetmealDish|body|object| 否 | SetmealDish|none|
|»»» copies|body|integer(int32)| 是 ||菜品份数|
|»»» dishId|body|integer(int64)| 是 ||菜品id|
|»»» id|body|integer(int64)| 否 ||关系表主键值|
|»»» name|body|string| 是 ||菜品名称|
|»»» price|body|number| 是 ||菜品价格|
|»»» setmealId|body|integer(int64)| 否 ||套餐id|
|» status|body|integer(int32)| 否 ||套餐起售状态|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none||none|
|» msg|string|false|none||none|

## DELETE 批量删除套餐

DELETE /admin/setmeal

> Body 请求参数

```
string

```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|ids|query|string| 是 ||ids|
|body|body|string| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|false|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## POST 新增套餐

POST /admin/setmeal

> Body 请求参数

```json
{
  "categoryId": 0,
  "description": "string",
  "id": 0,
  "image": "string",
  "name": "string",
  "price": 0,
  "setmealDishes": [
    {
      "copies": 0,
      "dishId": 0,
      "id": 0,
      "name": "string",
      "price": 0,
      "setmealId": 0
    }
  ],
  "status": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | SetmealDTO|none|
|» categoryId|body|integer(int64)| 是 ||分类id|
|» description|body|string| 否 ||套餐描述|
|» id|body|integer(int64)| 否 ||套餐id|
|» image|body|string| 是 ||套餐图片|
|» name|body|string| 是 ||套餐名称|
|» price|body|number| 是 ||套餐价格|
|» setmealDishes|body|[object]| 是 ||套餐包含的菜品|
|»» SetmealDish|body|object| 否 | SetmealDish|none|
|»»» copies|body|integer(int32)| 是 ||份数|
|»»» dishId|body|integer(int64)| 是 ||菜品id|
|»»» id|body|integer(int64)| 否 ||套餐和菜品关系id|
|»»» name|body|string| 是 ||菜品名称|
|»»» price|body|number| 是 ||菜品价格|
|»»» setmealId|body|integer(int64)| 是 ||套餐id|
|» status|body|integer(int32)| 是 ||套餐状态：1位起售 0为停售|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## GET 分页查询

GET /admin/setmeal/page

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|categoryId|query|string| 否 ||分类id|
|name|query|string| 否 ||套餐名称|
|page|query|string| 是 ||页码|
|pageSize|query|string| 是 ||每页记录数|
|status|query|string| 否 ||套餐起售状态|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "msg": null,
  "data": {
    "total": 0,
    "records": [
      {
        "id": 0,
        "categoryId": 0,
        "name": "string",
        "price": 0,
        "status": 0,
        "description": "string",
        "image": "string",
        "updateTime": "string",
        "categoryName": "string"
      }
    ]
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|true|none||none|
|» msg|null|false|none||none|
|» data|object|false|none||none|
|»» total|number|false|none||none|
|»» records|[object]|false|none||none|
|»»» id|number|true|none||none|
|»»» categoryId|number|true|none||none|
|»»» name|string|true|none||none|
|»»» price|number|true|none||none|
|»»» status|number|true|none||none|
|»»» description|string|true|none||none|
|»»» image|string|true|none||none|
|»»» updateTime|string|true|none||none|
|»»» categoryName|string|true|none||none|

## POST 套餐起售、停售

POST /admin/setmeal/status/{status}

> Body 请求参数

```json
{}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|status|path|string| 是 ||套餐状态，1表示起售，0表示停售|
|id|query|string| 是 ||套餐id|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## GET 根据id查询套餐

GET /admin/setmeal/{id}

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|path|string| 是 ||套餐id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "categoryId": 0,
    "categoryName": "string",
    "description": "string",
    "id": 0,
    "image": "string",
    "name": "string",
    "price": 0,
    "setmealDishes": [
      {
        "copies": 0,
        "dishId": 0,
        "id": 0,
        "name": "string",
        "price": 0,
        "setmealId": 0
      }
    ],
    "status": 0,
    "updateTime": "2019-08-24T14:15:22Z"
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«SetmealVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none|SetmealVO|none|
|»» categoryId|integer(int64)|true|none||none|
|»» categoryName|string|true|none||none|
|»» description|string|true|none||none|
|»» id|integer(int64)|true|none||none|
|»» image|string|true|none||none|
|»» name|string|true|none||none|
|»» price|number|true|none||none|
|»» setmealDishes|[object]|true|none||none|
|»»» SetmealDish|object|false|none|SetmealDish|none|
|»»»» copies|integer(int32)|true|none||none|
|»»»» dishId|integer(int64)|true|none||none|
|»»»» id|integer(int64)|true|none||none|
|»»»» name|string|true|none||none|
|»»»» price|number|true|none||none|
|»»»» setmealId|integer(int64)|true|none||none|
|»» status|integer(int32)|true|none||none|
|»» updateTime|string(date-time)|true|none||none|
|» msg|string|false|none||none|

# 工作台接口

## GET 查询今日运营数据

GET /admin/workspace/businessData

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "newUsers": 0,
    "orderCompletionRate": 0.1,
    "turnover": 0.1,
    "unitPrice": 0.1,
    "validOrderCount": 0
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«BusinessDataVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none|BusinessDataVO|none|
|»» newUsers|integer(int32)|true|none||新增用户数|
|»» orderCompletionRate|number(double)|true|none||订单完成率|
|»» turnover|number(double)|true|none||营业额|
|»» unitPrice|number(double)|true|none||平均客单价|
|»» validOrderCount|integer(int32)|true|none||有效订单数|
|» msg|string|false|none||none|

## GET 查询套餐总览

GET /admin/workspace/overviewSetmeals

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "discontinued": 0,
    "sold": 0
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«SetmealOverViewVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none|SetmealOverViewVO|none|
|»» discontinued|integer(int32)|true|none||已停售套餐数量|
|»» sold|integer(int32)|true|none||已启售套餐数量|
|» msg|string|false|none||none|

## GET 查询菜品总览

GET /admin/workspace/overviewDishes

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "discontinued": 0,
    "sold": 0
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«DishOverViewVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none|DishOverViewVO|none|
|»» discontinued|integer(int32)|true|none||已停售菜品数量|
|»» sold|integer(int32)|true|none||已启售菜品数量|
|» msg|string|false|none||none|

## GET 查询订单管理数据

GET /admin/workspace/overviewOrders

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "allOrders": 0,
    "cancelledOrders": 0,
    "completedOrders": 0,
    "deliveredOrders": 0,
    "waitingOrders": 0
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«OrderOverViewVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none|OrderOverViewVO|none|
|»» allOrders|integer(int32)|true|none||全部订单|
|»» cancelledOrders|integer(int32)|true|none||已取消数量|
|»» completedOrders|integer(int32)|true|none||已完成数量|
|»» deliveredOrders|integer(int32)|true|none||待派送数量|
|»» waitingOrders|integer(int32)|true|none||待接单数量|
|» msg|string|false|none||none|

# 店铺操作接口

## GET 获取营业状态

GET /admin/shop/status

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": 0,
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«int»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|integer(int32)|true|none||店铺营业状态：1为营业，0为打烊|
|» msg|string|false|none||none|

## PUT 设置营业状态

PUT /admin/shop/{status}

> Body 请求参数

```json
{}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|status|path|string| 是 ||店铺营业状态：1为营业，0为打烊|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|

# 数据统计相关接口

## GET 导出Excel报表接口

GET /admin/report/export

> 返回示例

> 200 Response

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

### 返回数据结构

## GET 查询销量排名top10接口

GET /admin/report/top10

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|begin|query|string| 是 ||开始日期|
|end|query|string| 是 ||结束日期|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "nameList": "string",
    "numberList": "string"
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«SalesTop10ReportVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none|SalesTop10ReportVO|none|
|»» nameList|string|true|none||商品名称列表，以逗号分隔|
|»» numberList|string|true|none||销量列表，以逗号分隔|
|» msg|string|false|none||none|

## GET 用户统计接口

GET /admin/report/userStatistics

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|begin|query|string| 是 ||开始日期|
|end|query|string| 是 ||结束日期|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "dateList": "string",
    "newUserList": "string",
    "totalUserList": "string"
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«UserReportVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none|UserReportVO|none|
|»» dateList|string|true|none||日期列表，以逗号分隔|
|»» newUserList|string|true|none||新增用户数列表，以逗号分隔|
|»» totalUserList|string|true|none||总用户量列表，以逗号分隔|
|» msg|string|false|none||none|

## GET 营业额统计接口

GET /admin/report/turnoverStatistics

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|begin|query|string| 是 ||开始日期|
|end|query|string| 是 ||结束日期|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "dateList": "string",
    "turnoverList": "string"
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«TurnoverReportVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none|TurnoverReportVO|none|
|»» dateList|string|true|none||日期列表，日期之间以逗号分隔|
|»» turnoverList|string|true|none||营业额列表，营业额之间以逗号分隔|
|» msg|string|false|none||none|

## GET 订单统计接口

GET /admin/report/ordersStatistics

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|begin|query|string| 是 ||开始日期|
|end|query|string| 是 ||结束日期|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "dateList": "string",
    "orderCompletionRate": 0.1,
    "orderCountList": "string",
    "totalOrderCount": 0,
    "validOrderCount": 0,
    "validOrderCountList": "string"
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«OrderReportVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none|OrderReportVO|none|
|»» dateList|string|true|none||日期列表，以逗号分隔|
|»» orderCompletionRate|number(double)|true|none||订单完成率|
|»» orderCountList|string|true|none||订单数列表，以逗号分隔|
|»» totalOrderCount|integer(int32)|true|none||订单总数|
|»» validOrderCount|integer(int32)|true|none||有效订单数|
|»» validOrderCountList|string|true|none||有效订单数列表，以逗号分隔|
|» msg|string|false|none||none|

# 菜品相关接口

## PUT 修改菜品

PUT /admin/dish

> Body 请求参数

```json
{
  "categoryId": 0,
  "description": "string",
  "flavors": [
    {
      "dishId": 0,
      "id": 0,
      "name": "string",
      "value": "string"
    }
  ],
  "id": 0,
  "image": "string",
  "name": "string",
  "price": 0,
  "status": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | DishDTO|none|
|» categoryId|body|integer(int64)| 是 ||none|
|» description|body|string| 否 ||none|
|» flavors|body|[object]| 否 ||none|
|»» DishFlavor|body|object| 否 | DishFlavor|none|
|»»» dishId|body|integer(int64)| 否 ||none|
|»»» id|body|integer(int64)| 否 ||none|
|»»» name|body|string| 是 ||none|
|»»» value|body|string| 是 ||none|
|» id|body|integer(int64)| 是 ||none|
|» image|body|string| 是 ||none|
|» name|body|string| 是 ||none|
|» price|body|number| 是 ||none|
|» status|body|integer(int32)| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|

## DELETE 批量删除菜品

DELETE /admin/dish

> Body 请求参数

```
string

```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|ids|query|string| 是 ||菜品id，之间用逗号分隔|
|body|body|string| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|

## POST 新增菜品

POST /admin/dish

> Body 请求参数

```json
{
  "categoryId": 0,
  "description": "string",
  "flavors": [
    {
      "dishId": 0,
      "id": 0,
      "name": "string",
      "value": "string"
    }
  ],
  "id": 0,
  "image": "string",
  "name": "string",
  "price": 0,
  "status": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | DishDTO|none|
|» categoryId|body|integer(int64)| 是 ||分类id|
|» description|body|string| 否 ||菜品描述|
|» flavors|body|[object]| 否 ||口味|
|»» DishFlavor|body|object| 否 | DishFlavor|none|
|»»» dishId|body|integer(int64)| 否 ||菜品id|
|»»» id|body|integer(int64)| 否 ||口味id|
|»»» name|body|string| 是 ||口味名称|
|»»» value|body|string| 是 ||口味值|
|» id|body|integer(int64)| 否 ||菜品id|
|» image|body|string| 是 ||菜品图片路径|
|» name|body|string| 是 ||菜品名称|
|» price|body|number| 是 ||菜品价格|
|» status|body|integer(int32)| 否 ||菜品状态：1为起售，0为停售|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|

## GET 根据id查询菜品

GET /admin/dish/{id}

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|path|string| 是 ||菜品id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "categoryId": 0,
    "categoryName": "string",
    "description": "string",
    "flavors": [
      {
        "dishId": 0,
        "id": 0,
        "name": "string",
        "value": "string"
      }
    ],
    "id": 0,
    "image": "string",
    "name": "string",
    "price": 0,
    "status": 0,
    "updateTime": "2019-08-24T14:15:22Z"
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«DishVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none|DishVO|none|
|»» categoryId|integer(int64)|true|none||none|
|»» categoryName|string|true|none||none|
|»» description|string|true|none||none|
|»» flavors|[object]|true|none||none|
|»»» DishFlavor|object|false|none|DishFlavor|none|
|»»»» dishId|integer(int64)|true|none||none|
|»»»» id|integer(int64)|true|none||none|
|»»»» name|string|true|none||none|
|»»»» value|string|true|none||none|
|»» id|integer(int64)|true|none||none|
|»» image|string|true|none||none|
|»» name|string|true|none||none|
|»» price|number|true|none||none|
|»» status|integer(int32)|true|none||none|
|»» updateTime|string(date-time)|true|none||none|
|» msg|string|false|none||none|

## GET 根据分类id查询菜品

GET /admin/dish/list

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|categoryId|query|string| 是 ||分类id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": [
    {
      "categoryId": 0,
      "createTime": "2019-08-24T14:15:22Z",
      "createUser": 0,
      "description": "string",
      "id": 0,
      "image": "string",
      "name": "string",
      "price": 0,
      "status": 0,
      "updateTime": "2019-08-24T14:15:22Z",
      "updateUser": 0
    }
  ],
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«List«Dish»»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|[object]|false|none||none|
|»» Dish|object|false|none|Dish|none|
|»»» categoryId|integer(int64)|false|none||none|
|»»» createTime|string(date-time)|false|none||none|
|»»» createUser|integer(int64)|false|none||none|
|»»» description|string|false|none||none|
|»»» id|integer(int64)|false|none||none|
|»»» image|string|false|none||none|
|»»» name|string|false|none||none|
|»»» price|number|false|none||none|
|»»» status|integer(int32)|false|none||none|
|»»» updateTime|string(date-time)|false|none||none|
|»»» updateUser|integer(int64)|false|none||none|
|» msg|string|false|none||none|

## GET 菜品分页查询

GET /admin/dish/page

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|categoryId|query|string| 否 ||分类id|
|name|query|string| 否 ||菜品名称|
|page|query|string| 是 ||页码|
|pageSize|query|string| 是 ||每页记录数|
|status|query|string| 否 ||分类状态|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "msg": null,
  "data": {
    "total": 0,
    "records": [
      {
        "id": 0,
        "name": "string",
        "categoryId": 0,
        "price": 0,
        "image": "string",
        "description": "string",
        "status": 0,
        "updateTime": "string",
        "categoryName": "string"
      }
    ]
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|true|none||none|
|» msg|null|false|none||none|
|» data|object|false|none||none|
|»» total|number|true|none||总记录数|
|»» records|[object]|true|none||当前页数据|
|»»» id|number|true|none||none|
|»»» name|string|true|none||none|
|»»» categoryId|number|true|none||none|
|»»» price|number|true|none||none|
|»»» image|string|true|none||none|
|»»» description|string|true|none||none|
|»»» status|number|true|none||none|
|»»» updateTime|string|true|none||none|
|»»» categoryName|string|true|none||分类名称|

## POST 菜品起售、停售

POST /admin/dish/status/{status}

> Body 请求参数

```json
{}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|status|path|string| 是 ||菜品状态：1为起售，0为停售|
|id|query|string| 是 ||菜品id|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|

# 订单管理接口

## PUT 取消订单

PUT /admin/order/cancel

> Body 请求参数

```json
{
  "cancelReason": "string",
  "id": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | OrdersCancelDTO|none|
|» cancelReason|body|string| 是 ||订单取消原因|
|» id|body|integer(int64)| 是 ||订单id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## GET 各个状态的订单数量统计

GET /admin/order/statistics

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "confirmed": 0,
    "deliveryInProgress": 0,
    "toBeConfirmed": 0
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«OrderStatisticsVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none|OrderStatisticsVO|none|
|»» confirmed|integer(int32)|true|none||待派送数量|
|»» deliveryInProgress|integer(int32)|true|none||派送中数量|
|»» toBeConfirmed|integer(int32)|true|none||待接单数量|
|» msg|string|false|none||none|

## PUT 完成订单

PUT /admin/order/complete/{id}

> Body 请求参数

```
string

```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|path|string| 是 ||订单id|
|Content-Type|header|string| 是 ||none|
|body|body|string| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## PUT 拒单

PUT /admin/order/rejection

> Body 请求参数

```json
{
  "id": 0,
  "rejectionReason": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | OrdersRejectionDTO|none|
|» id|body|integer(int64)| 是 ||订单id|
|» rejectionReason|body|string| 是 ||拒单原因|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## PUT 接单

PUT /admin/order/confirm

> Body 请求参数

```json
{
  "id": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | OrdersConfirmDTO|none|
|» id|body|integer(int64)| 是 ||订单id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## GET 查询订单详情

GET /admin/order/details/{id}

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|path|string| 是 ||订单id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "address": "string",
    "addressBookId": 0,
    "amount": 0,
    "cancelReason": "string",
    "cancelTime": "2019-08-24T14:15:22Z",
    "checkoutTime": "2019-08-24T14:15:22Z",
    "consignee": "string",
    "deliveryStatus": 0,
    "deliveryTime": "2019-08-24T14:15:22Z",
    "estimatedDeliveryTime": "2019-08-24T14:15:22Z",
    "id": 0,
    "number": "string",
    "orderDetailList": [
      {
        "amount": 0,
        "dishFlavor": "string",
        "dishId": 0,
        "id": 0,
        "image": "string",
        "name": "string",
        "number": 0,
        "orderId": 0,
        "setmealId": 0
      }
    ],
    "orderDishes": "string",
    "orderTime": "2019-08-24T14:15:22Z",
    "packAmount": 0,
    "payMethod": 0,
    "payStatus": 0,
    "phone": "string",
    "rejectionReason": "string",
    "remark": "string",
    "status": 0,
    "tablewareNumber": 0,
    "tablewareStatus": 0,
    "userId": 0,
    "userName": "string"
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«OrderVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none|OrderVO|none|
|»» address|string|false|none||none|
|»» addressBookId|integer(int64)|false|none||none|
|»» amount|number|false|none||none|
|»» cancelReason|string|false|none||none|
|»» cancelTime|string(date-time)|false|none||none|
|»» checkoutTime|string(date-time)|false|none||none|
|»» consignee|string|false|none||none|
|»» deliveryStatus|integer(int32)|false|none||none|
|»» deliveryTime|string(date-time)|false|none||none|
|»» estimatedDeliveryTime|string(date-time)|false|none||none|
|»» id|integer(int64)|false|none||none|
|»» number|string|false|none||none|
|»» orderDetailList|[object]|false|none||none|
|»»» OrderDetail|object|false|none|OrderDetail|none|
|»»»» amount|number|false|none||none|
|»»»» dishFlavor|string|false|none||none|
|»»»» dishId|integer(int64)|false|none||none|
|»»»» id|integer(int64)|false|none||none|
|»»»» image|string|false|none||none|
|»»»» name|string|false|none||none|
|»»»» number|integer(int32)|false|none||none|
|»»»» orderId|integer(int64)|false|none||none|
|»»»» setmealId|integer(int64)|false|none||none|
|»» orderDishes|string|false|none||none|
|»» orderTime|string(date-time)|false|none||none|
|»» packAmount|integer(int32)|false|none||none|
|»» payMethod|integer(int32)|false|none||none|
|»» payStatus|integer(int32)|false|none||none|
|»» phone|string|false|none||none|
|»» rejectionReason|string|false|none||none|
|»» remark|string|false|none||none|
|»» status|integer(int32)|false|none||none|
|»» tablewareNumber|integer(int32)|false|none||none|
|»» tablewareStatus|integer(int32)|false|none||none|
|»» userId|integer(int64)|false|none||none|
|»» userName|string|false|none||none|
|» msg|string|false|none||none|

## PUT 派送订单

PUT /admin/order/delivery/{id}

> Body 请求参数

```
string

```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|path|string| 是 ||订单id|
|body|body|string| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## GET 订单搜索

GET /admin/order/conditionSearch

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|beginTime|query|string| 否 ||beginTime|
|endTime|query|string| 否 ||endTime|
|number|query|string| 否 ||number|
|page|query|string| 是 ||page|
|pageSize|query|string| 是 ||pageSize|
|phone|query|string| 否 ||phone|
|status|query|string| 否 ||status|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "msg": null,
  "data": {
    "total": 0,
    "records": [
      {
        "id": 0,
        "number": "string",
        "status": 0,
        "userId": 0,
        "addressBookId": 0,
        "orderTime": "string",
        "checkoutTime": null,
        "payMethod": 0,
        "payStatus": 0,
        "amount": 0,
        "remark": "string",
        "userName": "string",
        "phone": "string",
        "address": "string",
        "consignee": "string",
        "cancelReason": "string",
        "rejectionReason": "string",
        "cancelTime": "string",
        "estimatedDeliveryTime": "string",
        "deliveryStatus": 0,
        "deliveryTime": "string",
        "packAmount": 0,
        "tablewareNumber": 0,
        "tablewareStatus": 0,
        "orderDishes": "string"
      }
    ]
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|true|none||none|
|» msg|null|false|none||none|
|» data|object|false|none||none|
|»» total|number|false|none||none|
|»» records|[object]|false|none||none|
|»»» id|number|true|none||none|
|»»» number|string|true|none||none|
|»»» status|number|true|none||none|
|»»» userId|number|true|none||none|
|»»» addressBookId|number|true|none||none|
|»»» orderTime|string|true|none||none|
|»»» checkoutTime|null¦null|true|none||none|
|»»» payMethod|number|true|none||none|
|»»» payStatus|number|true|none||none|
|»»» amount|number|true|none||none|
|»»» remark|string|true|none||none|
|»»» userName|string|true|none||none|
|»»» phone|string|true|none||none|
|»»» address|string|true|none||none|
|»»» consignee|string|true|none||none|
|»»» cancelReason|string|true|none||none|
|»»» rejectionReason|string|true|none||none|
|»»» cancelTime|string|true|none||none|
|»»» estimatedDeliveryTime|string|true|none||none|
|»»» deliveryStatus|number|true|none||none|
|»»» deliveryTime|string|true|none||none|
|»»» packAmount|number|true|none||none|
|»»» tablewareNumber|number|true|none||none|
|»»» tablewareStatus|number|true|none||none|
|»»» orderDishes|string|true|none||订单包含的菜品，以字符串形式展示|

# 通用接口

## POST 文件上传

POST /admin/common/upload

> Body 请求参数

```yaml
file: string

```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 ||none|
|» file|body|string(binary)| 是 ||文件|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|true|none||文件上传路径|
|» msg|string|false|none||none|





---
title: 苍穹外卖-用户端接口
language_tabs:
- shell: Shell
- http: HTTP
- javascript: JavaScript
- ruby: Ruby
- python: Python
- php: PHP
- java: Java
- go: Go
  toc_footers: []
  includes: []
  search: true
  code_clipboard: true
  highlight_theme: darkula
  headingLevel: 2
  generator: "@tarslib/widdershins v4.0.23"

---

# 苍穹外卖-用户端接口

Base URLs:

# Authentication

# C端-分类接口

## GET 条件查询

GET /user/category/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|type|query|string| 否 |分类类型：1 菜品分类 2 套餐分类|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": [
    {
      "createTime": "2019-08-24T14:15:22Z",
      "createUser": 0,
      "id": 0,
      "name": "string",
      "sort": 0,
      "status": 0,
      "type": 0,
      "updateTime": "2019-08-24T14:15:22Z",
      "updateUser": 0
    }
  ],
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«List«Category»»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|[object]|false|none||none|
|»» Category|object|false|none|Category|none|
|»»» createTime|string(date-time)|false|none||none|
|»»» createUser|integer(int64)|false|none||none|
|»»» id|integer(int64)|false|none||none|
|»»» name|string|false|none||none|
|»»» sort|integer(int32)|false|none||none|
|»»» status|integer(int32)|false|none||none|
|»»» type|integer(int32)|false|none||none|
|»»» updateTime|string(date-time)|false|none||none|
|»»» updateUser|integer(int64)|false|none||none|
|» msg|string|false|none||none|

# C端-地址簿接口

## POST 新增地址

POST /user/addressBook

> Body 请求参数

```json
{
  "cityCode": "string",
  "cityName": "string",
  "consignee": "string",
  "detail": "string",
  "districtCode": "string",
  "districtName": "string",
  "id": 0,
  "isDefault": 0,
  "label": "string",
  "phone": "string",
  "provinceCode": "string",
  "provinceName": "string",
  "sex": "string",
  "userId": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | AddressBook|none|
|» cityCode|body|string| 否 ||none|
|» cityName|body|string| 否 ||none|
|» consignee|body|string| 否 ||none|
|» detail|body|string| 是 ||详细地址|
|» districtCode|body|string| 否 ||none|
|» districtName|body|string| 否 ||none|
|» id|body|integer(int64)| 否 ||none|
|» isDefault|body|integer(int32)| 否 ||none|
|» label|body|string| 否 ||none|
|» phone|body|string| 是 ||手机号|
|» provinceCode|body|string| 否 ||none|
|» provinceName|body|string| 否 ||none|
|» sex|body|string| 是 ||none|
|» userId|body|integer(int64)| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## PUT 根据id修改地址

PUT /user/addressBook

> Body 请求参数

```json
{
  "cityCode": "string",
  "cityName": "string",
  "consignee": "string",
  "detail": "string",
  "districtCode": "string",
  "districtName": "string",
  "id": 0,
  "isDefault": 0,
  "label": "string",
  "phone": "string",
  "provinceCode": "string",
  "provinceName": "string",
  "sex": "string",
  "userId": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | AddressBook|none|
|» cityCode|body|string| 否 ||none|
|» cityName|body|string| 否 ||none|
|» consignee|body|string| 否 ||none|
|» detail|body|string| 是 ||详细地址|
|» districtCode|body|string| 否 ||none|
|» districtName|body|string| 否 ||none|
|» id|body|integer(int64)| 是 ||主键值|
|» isDefault|body|integer(int32)| 否 ||none|
|» label|body|string| 否 ||none|
|» phone|body|string| 是 ||手机号|
|» provinceCode|body|string| 否 ||none|
|» provinceName|body|string| 否 ||none|
|» sex|body|string| 是 ||none|
|» userId|body|integer(int64)| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## DELETE 根据id删除地址

DELETE /user/addressBook

> Body 请求参数

```
string

```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|query|string| 是 ||地址id|
|body|body|string| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## GET 查询当前登录用户的所有地址信息

GET /user/addressBook/list

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "userId": 0,
    "consignee": "string",
    "phone": "string",
    "sex": "string",
    "provinceCode": "string",
    "provinceName": "string",
    "cityCode": "string",
    "cityName": "string",
    "districtCode": "string",
    "districtName": "string",
    "detail": "string",
    "label": "string",
    "isDefault": 0
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|»» id|number|true|none||none|
|»» userId|number|true|none||none|
|»» consignee|string|true|none||none|
|»» phone|string|true|none||none|
|»» sex|string|true|none||none|
|»» provinceCode|string|true|none||none|
|»» provinceName|string|true|none||none|
|»» cityCode|string|true|none||none|
|»» cityName|string|true|none||none|
|»» districtCode|string|true|none||none|
|»» districtName|string|true|none||none|
|»» detail|string|true|none||none|
|»» label|string|true|none||none|
|»» isDefault|number|true|none||none|
|» msg|string|false|none||none|

## GET 查询默认地址

GET /user/addressBook/default

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "cityCode": "string",
    "cityName": "string",
    "consignee": "string",
    "detail": "string",
    "districtCode": "string",
    "districtName": "string",
    "id": 0,
    "isDefault": 0,
    "label": "string",
    "phone": "string",
    "provinceCode": "string",
    "provinceName": "string",
    "sex": "string",
    "userId": 0
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«AddressBook»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none|AddressBook|none|
|»» cityCode|string|false|none||none|
|»» cityName|string|false|none||none|
|»» consignee|string|false|none||none|
|»» detail|string|false|none||none|
|»» districtCode|string|false|none||none|
|»» districtName|string|false|none||none|
|»» id|integer(int64)|false|none||none|
|»» isDefault|integer(int32)|false|none||none|
|»» label|string|false|none||none|
|»» phone|string|false|none||none|
|»» provinceCode|string|false|none||none|
|»» provinceName|string|false|none||none|
|»» sex|string|false|none||none|
|»» userId|integer(int64)|false|none||none|
|» msg|string|false|none||none|

## PUT 设置默认地址

PUT /user/addressBook/default

> Body 请求参数

```json
{
  "id": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | AddressBook|none|
|» id|body|integer(int64)| 是 ||地址id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## GET 根据id查询地址

GET /user/addressBook/{id}

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|path|string| 是 ||地址id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "phone": "string",
    "consignee": "string",
    "userId": 0,
    "cityCode": "string",
    "provinceName": "string",
    "provinceCode": "string",
    "sex": "string",
    "districtName": "string",
    "districtCode": "string",
    "cityName": "string",
    "isDefault": 0,
    "label": "string",
    "detail": "string"
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|true|none||none|
|» data|object|true|none||none|
|»» id|number|false|none||none|
|»» phone|string|false|none||none|
|»» consignee|string|false|none||none|
|»» userId|number|false|none||none|
|»» cityCode|string|false|none||none|
|»» provinceName|string|false|none||none|
|»» provinceCode|string|false|none||none|
|»» sex|string|false|none||none|
|»» districtName|string|false|none||none|
|»» districtCode|string|false|none||none|
|»» cityName|string|false|none||none|
|»» isDefault|number|false|none||none|
|»» label|string|false|none||none|
|»» detail|string|false|none||none|
|» msg|string|false|none||none|

# C端-套餐浏览接口

## GET 根据分类id查询套餐

GET /user/setmeal/list

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|categoryId|query|string| 是 ||分类id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": [
    {
      "categoryId": 0,
      "createTime": "2019-08-24T14:15:22Z",
      "createUser": 0,
      "description": "string",
      "id": 0,
      "image": "string",
      "name": "string",
      "price": 0,
      "status": 0,
      "updateTime": "2019-08-24T14:15:22Z",
      "updateUser": 0
    }
  ],
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«List«Setmeal»»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|[object]|false|none||none|
|»» Setmeal|object|false|none|Setmeal|none|
|»»» categoryId|integer(int64)|false|none||none|
|»»» createTime|string(date-time)|false|none||none|
|»»» createUser|integer(int64)|false|none||none|
|»»» description|string|false|none||none|
|»»» id|integer(int64)|false|none||none|
|»»» image|string|false|none||none|
|»»» name|string|false|none||none|
|»»» price|number|false|none||none|
|»»» status|integer(int32)|false|none||none|
|»»» updateTime|string(date-time)|false|none||none|
|»»» updateUser|integer(int64)|false|none||none|
|» msg|string|false|none||none|

## GET 根据套餐id查询包含的菜品

GET /user/setmeal/dish/{id}

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|path|string| 是 ||套餐id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": [
    {
      "copies": 0,
      "description": "string",
      "image": "string",
      "name": "string"
    }
  ],
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«List«DishItemVO»»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|[object]|true|none||none|
|»» DishItemVO|object|false|none|DishItemVO|none|
|»»» copies|integer(int32)|true|none||份数|
|»»» description|string|true|none||菜品描述|
|»»» image|string|true|none||菜品图片路径|
|»»» name|string|true|none||菜品名称|
|» msg|string|false|none||none|

# C端-店铺操作接口

## GET 获取营业状态

GET /user/shop/status

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": 0,
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«int»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|integer(int32)|true|none||店铺状态：1为营业，0为打烊|
|» msg|string|false|none||none|

# C端-用户接口

## POST 登录

POST /user/user/login

> Body 请求参数

```json
{
  "code": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | UserLoginDTO|none|
|» code|body|string| 是 ||微信授权码|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "openid": "string",
    "token": "string"
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«UserLoginVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none|UserLoginVO|none|
|»» id|integer(int64)|true|none||用户id|
|»» openid|string|true|none||微信用户openid|
|»» token|string|true|none||jwt令牌|
|» msg|string|false|none||none|

## POST 退出

POST /user/user/logout

> Body 请求参数

```json
{}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | empty object|none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

# C端-菜品浏览接口

## GET 根据分类id查询菜品

GET /user/dish/list

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|categoryId|query|string| 是 ||分类id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": [
    {
      "categoryId": 0,
      "categoryName": "string",
      "description": "string",
      "flavors": [
        {
          "dishId": 0,
          "id": 0,
          "name": "string",
          "value": "string"
        }
      ],
      "id": 0,
      "image": "string",
      "name": "string",
      "price": 0,
      "status": 0,
      "updateTime": "2019-08-24T14:15:22Z"
    }
  ],
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«List«DishVO»»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|[object]|false|none||none|
|»» DishVO|object|false|none|DishVO|none|
|»»» categoryId|integer(int64)|false|none||none|
|»»» categoryName|string|false|none||none|
|»»» description|string|false|none||none|
|»»» flavors|[object]|false|none||菜品口味|
|»»»» DishFlavor|object|false|none|DishFlavor|none|
|»»»»» dishId|integer(int64)|false|none||none|
|»»»»» id|integer(int64)|false|none||none|
|»»»»» name|string|false|none||none|
|»»»»» value|string|false|none||none|
|»»» id|integer(int64)|false|none||none|
|»»» image|string|false|none||菜品图片路径|
|»»» name|string|false|none||菜品名称|
|»»» price|number|false|none||价格|
|»»» status|integer(int32)|false|none||none|
|»»» updateTime|string(date-time)|false|none||none|
|» msg|string|false|none||none|

# C端-订单接口

## GET 催单

GET /user/order/reminder/{id}

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|path|string| 是 ||订单id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## POST 再来一单

POST /user/order/repetition/{id}

> Body 请求参数

```
string

```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|path|string| 是 ||订单id|
|body|body|string| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## GET 历史订单查询

GET /user/order/historyOrders

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|page|query|string| 是 ||页面|
|pageSize|query|string| 是 ||每页记录数|
|status|query|string| 否 ||订单状态|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "msg": null,
  "data": {
    "total": 0,
    "records": [
      {
        "id": 0,
        "number": "string",
        "status": 0,
        "userId": 0,
        "addressBookId": 0,
        "orderTime": "string",
        "checkoutTime": "string",
        "payMethod": 0,
        "payStatus": 0,
        "amount": 0,
        "remark": "string",
        "userName": null,
        "phone": "string",
        "address": "string",
        "consignee": "string",
        "cancelReason": null,
        "rejectionReason": null,
        "cancelTime": null,
        "estimatedDeliveryTime": "string",
        "deliveryStatus": 0,
        "deliveryTime": null,
        "packAmount": 0,
        "tablewareNumber": 0,
        "tablewareStatus": 0,
        "orderDetailList": [
          {
            "id": null,
            "name": null,
            "orderId": null,
            "dishId": null,
            "setmealId": null,
            "dishFlavor": null,
            "number": null,
            "amount": null,
            "image": null
          }
        ]
      }
    ]
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|number|false|none||none|
|» msg|null|false|none||none|
|» data|object|false|none||none|
|»» total|number|false|none||none|
|»» records|[object]|false|none||none|
|»»» id|number|false|none||none|
|»»» number|string|false|none||none|
|»»» status|number|false|none||none|
|»»» userId|number|false|none||none|
|»»» addressBookId|number|false|none||none|
|»»» orderTime|string|false|none||none|
|»»» checkoutTime|string|false|none||none|
|»»» payMethod|number|false|none||none|
|»»» payStatus|number|false|none||none|
|»»» amount|number|false|none||none|
|»»» remark|string|false|none||none|
|»»» userName|null|false|none||none|
|»»» phone|string|false|none||none|
|»»» address|string|false|none||none|
|»»» consignee|string|false|none||none|
|»»» cancelReason|null|false|none||none|
|»»» rejectionReason|null|false|none||none|
|»»» cancelTime|null|false|none||none|
|»»» estimatedDeliveryTime|string|false|none||none|
|»»» deliveryStatus|number|false|none||none|
|»»» deliveryTime|null|false|none||none|
|»»» packAmount|number|false|none||none|
|»»» tablewareNumber|number|false|none||none|
|»»» tablewareStatus|number|false|none||none|
|»»» orderDetailList|[object]|false|none||none|
|»»»» id|number|true|none||none|
|»»»» name|string|true|none||none|
|»»»» orderId|number|true|none||none|
|»»»» dishId|number|true|none||none|
|»»»» setmealId|null|true|none||none|
|»»»» dishFlavor|null¦null|true|none||none|
|»»»» number|number|true|none||none|
|»»»» amount|number|true|none||none|
|»»»» image|string|true|none||none|

## PUT 取消订单

PUT /user/order/cancel/{id}

> Body 请求参数

```
string

```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|path|string| 是 ||订单id|
|body|body|string| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|false|none||none|
|» msg|string|false|none||none|

## GET 查询订单详情

GET /user/order/orderDetail/{id}

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|id|path|string| 是 ||订单id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "address": "string",
    "addressBookId": 0,
    "amount": 0,
    "cancelReason": "string",
    "cancelTime": "2019-08-24T14:15:22Z",
    "checkoutTime": "2019-08-24T14:15:22Z",
    "consignee": "string",
    "deliveryStatus": 0,
    "deliveryTime": "2019-08-24T14:15:22Z",
    "estimatedDeliveryTime": "2019-08-24T14:15:22Z",
    "id": 0,
    "number": "string",
    "orderDetailList": [
      {
        "amount": 0,
        "dishFlavor": "string",
        "dishId": 0,
        "id": 0,
        "image": "string",
        "name": "string",
        "number": 0,
        "orderId": 0,
        "setmealId": 0
      }
    ],
    "orderTime": "2019-08-24T14:15:22Z",
    "packAmount": 0,
    "payMethod": 0,
    "payStatus": 0,
    "phone": "string",
    "rejectionReason": "string",
    "remark": "string",
    "status": 0,
    "tablewareNumber": 0,
    "tablewareStatus": 0,
    "userId": 0,
    "userName": "string"
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«OrderVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|false|none||none|
|» data|object|false|none|OrderVO|none|
|»» address|string|false|none||none|
|»» addressBookId|integer(int64)|false|none||none|
|»» amount|number|false|none||none|
|»» cancelReason|string|false|none||none|
|»» cancelTime|string(date-time)|false|none||none|
|»» checkoutTime|string(date-time)|false|none||none|
|»» consignee|string|false|none||none|
|»» deliveryStatus|integer(int32)|false|none||none|
|»» deliveryTime|string(date-time)|false|none||none|
|»» estimatedDeliveryTime|string(date-time)|false|none||none|
|»» id|integer(int64)|false|none||none|
|»» number|string|false|none||none|
|»» orderDetailList|[object]|false|none||none|
|»»» OrderDetail|object|false|none|OrderDetail|none|
|»»»» amount|number|false|none||none|
|»»»» dishFlavor|string|false|none||none|
|»»»» dishId|integer(int64)|false|none||none|
|»»»» id|integer(int64)|false|none||none|
|»»»» image|string|false|none||none|
|»»»» name|string|false|none||none|
|»»»» number|integer(int32)|false|none||none|
|»»»» orderId|integer(int64)|false|none||none|
|»»»» setmealId|integer(int64)|false|none||none|
|»» orderTime|string(date-time)|false|none||none|
|»» packAmount|integer(int32)|false|none||none|
|»» payMethod|integer(int32)|false|none||none|
|»» payStatus|integer(int32)|false|none||none|
|»» phone|string|false|none||none|
|»» rejectionReason|string|false|none||none|
|»» remark|string|false|none||none|
|»» status|integer(int32)|false|none||none|
|»» tablewareNumber|integer(int32)|false|none||none|
|»» tablewareStatus|integer(int32)|false|none||none|
|»» userId|integer(int64)|false|none||none|
|»» userName|string|false|none||none|
|» msg|string|false|none||none|

## POST 用户下单

POST /user/order/submit

> Body 请求参数

```json
{
  "addressBookId": 0,
  "amount": 0,
  "deliveryStatus": 0,
  "estimatedDeliveryTime": "yyyy-MM-dd HH:mm:ss",
  "packAmount": 0,
  "payMethod": 0,
  "remark": "string",
  "tablewareNumber": 0,
  "tablewareStatus": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | OrdersSubmitDTO|none|
|» addressBookId|body|integer(int64)| 是 ||地址簿id|
|» amount|body|number| 是 ||总金额|
|» deliveryStatus|body|integer(int32)| 是 ||配送状态：  1立即送出  0选择具体时间|
|» estimatedDeliveryTime|body|string| 是 ||预计送达时间|
|» packAmount|body|integer(int32)| 是 ||打包费|
|» payMethod|body|integer(int32)| 是 ||付款方式|
|» remark|body|string| 是 ||备注|
|» tablewareNumber|body|integer(int32)| 是 ||餐具数量|
|» tablewareStatus|body|integer(int32)| 是 ||餐具数量状态  1按餐量提供  0选择具体数量|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "orderAmount": 0,
    "orderNumber": "string",
    "orderTime": "2019-08-24T14:15:22Z"
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«OrderSubmitVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none|OrderSubmitVO|none|
|»» id|integer(int64)|true|none||订单id|
|»» orderAmount|number|true|none||订单金额|
|»» orderNumber|string|true|none||订单号|
|»» orderTime|string(date-time)|true|none||下单时间|
|» msg|string|false|none||none|

## PUT 订单支付

PUT /user/order/payment

> Body 请求参数

```json
{
  "orderNumber": "string",
  "payMethod": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | OrdersPaymentDTO|none|
|» orderNumber|body|string| 是 ||订单号|
|» payMethod|body|integer(int32)| 是 ||支付方式|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": {
    "nonceStr": "2019-08-24T14:15:22Z",
    "paySign": "string",
    "timeStamp": "string",
    "signType": "string",
    "packageStr": "string"
  },
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«OrderPaymentVO»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|object|true|none|OrderPaymentVO|none|
|»» nonceStr|string(date-time)|true|none||随机字符串|
|»» paySign|string|true|none||签名|
|»» timeStamp|string|true|none||时间戳|
|»» signType|string|true|none||签名算法|
|»» packageStr|string|true|none||统一下单接口返回的 prepay_id 参数值|
|» msg|string|false|none||none|

# C端-购物车接口

## POST 删除购物车中一个商品

POST /user/shoppingCart/sub

> Body 请求参数

```json
{
  "dishFlavor": "string",
  "dishId": 0,
  "setmealId": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | ShoppingCartDTO|none|
|» dishFlavor|body|string| 否 ||口味|
|» dishId|body|integer(int64)| 否 ||菜品id|
|» setmealId|body|integer(int64)| 否 ||套餐id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|

## GET 查看购物车

GET /user/shoppingCart/list

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": [
    {
      "amount": 0,
      "createTime": "2019-08-24T14:15:22Z",
      "dishFlavor": "string",
      "dishId": 0,
      "id": 0,
      "image": "string",
      "name": "string",
      "number": 0,
      "setmealId": 0,
      "userId": 0
    }
  ],
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«List«ShoppingCart»»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|[object]|false|none||none|
|»» ShoppingCart|object|false|none|ShoppingCart|none|
|»»» amount|number|false|none||none|
|»»» createTime|string(date-time)|false|none||none|
|»»» dishFlavor|string|false|none||none|
|»»» dishId|integer(int64)|false|none||none|
|»»» id|integer(int64)|false|none||none|
|»»» image|string|false|none||none|
|»»» name|string|false|none||none|
|»»» number|integer(int32)|false|none||none|
|»»» setmealId|integer(int64)|false|none||none|
|»»» userId|integer(int64)|false|none||none|
|» msg|string|false|none||none|

## POST 添加购物车

POST /user/shoppingCart/add

> Body 请求参数

```json
{
  "dishFlavor": "string",
  "dishId": 0,
  "setmealId": 0
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Content-Type|header|string| 是 ||none|
|body|body|object| 否 | ShoppingCartDTO|none|
|» dishFlavor|body|string| 否 ||口味|
|» dishId|body|integer(int64)| 否 ||菜品id|
|» setmealId|body|integer(int64)| 否 ||套餐id|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|

## DELETE 清空购物车

DELETE /user/shoppingCart/clean

> Body 请求参数

```
string

```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|body|body|string| 否 ||none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": "string",
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### 返回数据结构

状态码 **200**

*R«string»*

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer(int32)|true|none||none|
|» data|string|false|none||none|
|» msg|string|false|none||none|







