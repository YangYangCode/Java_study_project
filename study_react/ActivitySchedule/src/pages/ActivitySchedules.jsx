import React, { useState } from "react";
import CardItem from "../components/CardItem";
import "./ActivitySchedules.css" ;

function ActivitySchedules() {

    // switch - 計算周一至周日
    // lsit

    
    return (
        <div>
            <h1>活動列表</h1>
            <div><h2> MM-dd ~ MM-dd </h2></div>
            <div>
                <h3>
                <button>上周活動</button>
                <button>下周活動</button>
                </h3>
            </div>


            <div className="head-week">
                <h1>
                    <ul className="week-list">
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

            {/* // 活動列表 */}
            <div >
                <ul className="week-all-activity">
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