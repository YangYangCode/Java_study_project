import React, { useState } from "react";
import CardItem from "../components/CardItem";
import "./CLassTypes.css" ;

function CLassTypes() {

    // switch - 計算周一至周日
    // lsit

    
    return (
        <div>
            <div>
                <h1>課程類型</h1>
            </div>


            <div className="bg-slate-500">

<div className="row">
    <div className=" bg-gray opacity-25 col-12 col-xl-2">教室名稱、圖片</div>
    <div className="col-12 col-xl-10">forEach-timeRange</div>
</div>

<div className="row">
    <div className=" bg-gray opacity-25 col-12 col-xl-2">教室名稱、圖片</div>
    <div className="col-12 col-xl-10">forEach-timeRange</div>
</div>

<div className="row">
    <div className=" bg-gray opacity-25 col-12 col-xl-2">教室名稱、圖片</div>
    <div className="col-12 col-xl-10">forEach-timeRange</div>
</div>

</div>
        
            {/* // 課程列表 */}
            <div >
                <ul className="class-type-lsit">
                    <li >
                        <CardItem></CardItem>
                    </li>

                    <li>
                        <CardItem></CardItem>
                    </li>

                    <li>
                        <CardItem></CardItem>
                    </li>

                    <li>
                        <CardItem></CardItem>
                    </li>

                    <li>
                        <CardItem></CardItem>
                    </li>
                    
                    <li>
                        <CardItem></CardItem>
                    </li>

                    <li>
                        <CardItem></CardItem>
                    </li>
                    
                </ul>
            </div>
        </div>
    );
}

export default CLassTypes;