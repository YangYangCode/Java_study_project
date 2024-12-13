import React, { useState } from "react";
import CardItem from "../components/CardItem";


function CLassRooms() {


    return (

        <div className="main">
            <div>
                <h1>教室列表</h1>
            </div>

            <div>

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


            // 房間列表
            <div className="flex gap-2">
            {[1,1,1,1,1].map((_,index)=>(<div key={index}><CardItem/></div>))}
            </div>



        </div>
    );
}

export default CLassRooms;