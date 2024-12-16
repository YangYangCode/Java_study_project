import React, { useState, useEffect } from "react";
import ActivityScheduleDataTable from "../component/AS_DataTable";
import { get_all_activitySchedule } from "../service/Service_AS";


function ManagerActivityList() {

    const [ActSch, setActSch] = useState('');  // 用於修改、新增的ActSch

    const [FromInput, setFromInput] = useState('');  // From 表單

    // 定義狀態來儲存從 API 獲得的活動資料
    const [activities, setActivities] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const ASList = await get_all_activitySchedule();
                setActivities(ASList);  // 將活動資料儲存進狀態
            } catch (error) {
                console.error("Error getAllAS:", error);  // 若有錯誤會在這裡處理
            }
        };
        fetchData();  // 呼叫 async 函數來取得資料
        // console.log(ActivitiesWithWeekday);  // 注意：ActivitiesWithWeekday 此時不會包含資料
    }, []);  // 空陣列表示只在組件首次渲染時觸發一次

    return (


        <div>
            <h1 className="text-6xl text-center font-semibold mb-2">活動清單</h1>

            

            <ActivityScheduleDataTable activities={activities} />

        </div>


    )
}

export default ManagerActivityList;