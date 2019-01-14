function count(arr, item) {
    var a=0;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i]==item){
            a++;
        }
    }
    return a;
}