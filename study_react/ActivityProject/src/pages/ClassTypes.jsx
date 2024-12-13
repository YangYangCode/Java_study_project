import React, { useState } from "react";
import CardItem from "../component/CT_CardItem";

function CLassTypes() {


    return (
        <div>
            <div>
                <h1>課程類型</h1>
            </div>


            {/* // 課程列表 */}
            <div >
                    // 房間列表
                    <div className="flex gap-2">
                        {[1, 1, 1, 1, 1].map((_, index) => (<div key={index}><CardItem /></div>))}
                    </div>

                <ul className="flex gap-2">
                <CardItem/>
                <CardItem/>
                <CardItem/>
                <CardItem/>
                <CardItem/>
                <CardItem/>
                <CardItem/>
                </ul>
            </div>
        </div>
    )
}

export default CLassTypes;