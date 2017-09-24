// 将日期类型转换成字符串型格式 yyyy-MM-dd 
Date.prototype.ChangeDateToString = function (DateIn){
    var Year = 0 ;
    var Month = 0 ;
    var Day = 0 ;
    var CurrentDate = "" ;
    // 初始化时间
    Year       = DateIn.getFullYear ();
    Month      = DateIn.getMonth ()+ 1 ;
    Day        = DateIn.getDate ();
    CurrentDate = Year + "-" ;
    if (Month >= 10){
        CurrentDate = CurrentDate + Month + "-" ;
    }else{
         CurrentDate = CurrentDate + "0" + Month + "-" ;
    }
    if ( Day >= 10 ){
        CurrentDate = CurrentDate + Day ;
    }else{
        CurrentDate = CurrentDate + "0" + Day ;
    }
    return CurrentDate ;
}
// 取得当前日期 , 格式 yyyy-mm-dd
Date.prototype.GetCurrentDate = function(){
	var year = 0 ;
    var Month = 0 ;
    var day = 0 ;
    var CurrentDate = new Date ();
    return CurrentDate.ChangeDateToString (CurrentDate);
}

