<%--
  Created by IntelliJ IDEA.
  User: ALEX
  Date: 23.11.2018
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- версия для разработки, отображает полезные предупреждения в консоли -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script>
        new Vue({
            el: '#app',
            data: {
                "firstName": "alex",
                "lastName": "ivanovich"
            }
            // ,
            // mounted() {
            //     axios
            //         .get('http://localhost:8080/users/1')
            //         .then(response => (this.info = response));
            // }
        });
    </script>
</head>
<body>
<div id="app">
    <div>
        {{firstName}}
    </div>
    <div>
        {{lastName}}
    </div>
</div>
</body>
</html>
