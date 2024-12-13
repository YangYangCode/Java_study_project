import React, { useState } from "react";
import CardItem from "../component/AS_CardItem";

function ActivitySchedules() {

    // (打資料庫)
    // 取得該周活動

    // (使用AS_Card)
    // switch - 計算周一至周日
    // list - 同一天

    // 一周 - ul包星期li  ->  星期ul 包活動 li

/*
    <ul className="list-disc ml-4">
        <li className="mb-2">
            <span className="font-bold">周一</span>
            <ul className="list-disc ml-6">
                <li className="mb-1">活動 1</li>
                <li className="mb-1">活動 2</li>
                <li className="mb-1">活動 3</li>
            </ul>
        </li>
            
        <li className="mb-2">
            <span className="font-bold">周二</span>
            <ul className="list-disc ml-6">
                <li className="mb-1">活動 1</li>
                <li className="mb-1">活動 2</li>
                <li className="mb-1">活動 3</li>
            </ul>
        </li>
    </ul>
*/

// update ->  


    return (
        <div>
            <h1>活動列表</h1>

            <div>
                <h3>
                    <button>上周活動</button>
                    <button>下周活動</button>
                </h3>
            </div>

            <div><h2> MM-dd ~ MM-dd </h2></div>


            <div className="head-week">
                <h1>
                    <ul className="flex">
                        <li>星期一</li>
                        <li>星期二</li>
                        <li>星期三</li>
                        <li>星期四</li>
                        <li>星期五</li>
                        <li>星期六</li>
                        <li>星期日</li>
                    </ul>
                </h1>
            </div>

            {/* // 活動列表，格式修改 */}
            <div >
                <ul className="flex">
                    <li className="monday-activity">
                        <CardItem></CardItem>
                        <CardItem></CardItem>
                        <CardItem></CardItem>
                        <CardItem></CardItem>
                    </li>
                    <li className="tuesday-activity">
                        <CardItem></CardItem>
                        <CardItem></CardItem>
                    </li>
                    <li className="wednesday-activity">
                        <CardItem></CardItem>
                        <CardItem></CardItem>
                        <CardItem></CardItem>
                    </li>
                    <li className="thursday-activity">
                        <CardItem></CardItem>
                        <CardItem></CardItem>
                        <CardItem></CardItem>
                        <CardItem></CardItem>
                        <CardItem></CardItem>
                    </li>
                    <li className="firday-activity">
                        <CardItem></CardItem>

                    </li>
                    <li className="saturday-activity">
                        <CardItem></CardItem>
                        <CardItem></CardItem>
                    </li>
                    <li className="sunday-activity">
                        <CardItem></CardItem>
                        <CardItem></CardItem>
                        <CardItem></CardItem>
                    </li>
                </ul>
            </div>
        </div>
    );
}

export default ActivitySchedules;