JQuery = function (selector) {
    // 封装document.getElementById
    if (typeof selector === "string") {
        if (selector.charAt(0) === "#") {
            // 全局变量不会销毁,不影响后面使用
            domObj = document.getElementById(selector.substring(1))
        }else if (selector.charAt(0) === ".") {
            domObj = document.getElementsByClassName(selector.substring(1))
        }
        return new JQuery();
    }
    // 封装window.onload
    if (typeof selector === "function") {
        window.onload = selector
    }
    // 封装innerHtml
    this.html = function (content) {
        domObj.innerHTML = content
    }
    // 封装onclick
    this.click = function (func) {
        domObj.onclick = func
    }
    this.blur = function (func) {
        domObj.onblur = func
    }
    // 封装value
    this.val = function (v) {
        if (v === undefined) {
            return domObj.value
        }
        domObj.value = v
    }
    this.change = function (func) {
        domObj.onchange = func
    }

    /**
     * 需要提供:
     * method   请求方式
     * url      统一资源定位符
     * async    是否支持异步请求
     * help     请求成功后执行的方法
     * data     传输过来的数据
     */
    JQuery.ajax = function (json) {
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (this.readyState === 4) {
                if (this.status > 199 && this.status < 300) {
                    json.help(JSON.parse(this.responseText))
                }else {
                    alert(this.status)
                }
            }
        }
        if (json.method.toUpperCase() === "GET") {
            xhr.open("GET", json.url + "?" + json.data, json.async);
            xhr.send();
        }else if (json.method.toUpperCase() === "POST") {
            xhr.open("POST", json.url, json.async)
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
            xhr.send(json.data)
        }
    }
}
$ = JQuery
// 调用该类的静态方法必须要先new对象
new JQuery();