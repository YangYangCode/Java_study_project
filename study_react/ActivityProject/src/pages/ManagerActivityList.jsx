import React, { useState } from "react";
import ActivityScheduleDataTable from "../component/AS_DataTable";
// import fData from "../component/fData";


function ManagerActivityList() {

    const [ActSch, setActSch] = useState('');  // 用於修改、新增的ActSch

    const [FromInput, setFromInput] = useState('');  // From 表單

    return (


        <div>
                <h1>活動清單</h1>


                <button className="bg-green-500 text-white px-4 py-2 mr-2 rounded-md">新增活動</button>
                    
            <ActivityScheduleDataTable/>

        </div>


    )
}

export default ManagerActivityList;