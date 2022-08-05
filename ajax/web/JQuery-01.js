JQuery = function (selector) {
    // 封装document.getElementById
    if (typeof selector === "string") {
        if (selector.charAt(0) === "#") {
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
}
$ = JQuery