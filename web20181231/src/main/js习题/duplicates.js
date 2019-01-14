function duplicates(arr) {
    var narr=[];
    for (var i = 0; i <arr.length; i++) {
        for (var j = i+1; j <arr.length; j++) {
            if (arr[i]==arr[j]){
                var a=0;
                for (var k = 0; k <narr.length ; k++) {
                    if (arr[i]==narr[k]){
                        a++;
                    }
                }
                if (a==0) {
                    narr.push(arr[i])
                }
            }
        }
    }
    return narr;
}
