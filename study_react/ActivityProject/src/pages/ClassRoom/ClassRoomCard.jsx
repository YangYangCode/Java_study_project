import React, { useEffect, useState } from "react";
import ClassRoom from "../../component/CR_Grid";
import { Link } from "react-router-dom";
import { get_all_classRoom } from "../../service/Service_AS";

function ClassRooms() {

    // 定義狀態來儲存從 API 獲得的活動資料
    const [classRooms, setClassRooms] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const CRList = await get_all_classRoom();
                setClassRooms(CRList);  // 將活動資料儲存進狀態
            } catch (error) {
                console.error("Error getAllClassRooms:", error);  // 若有錯誤會在這裡處理
            }
        };
        fetchData();  // 呼叫 async 函數來取得資料
        // console.log(ActivitiesWithWeekday);  // 注意：ActivitiesWithWeekday 此時不會包含資料
    }, []);  // 空陣列表示只在組件首次渲染時觸發一次


    return (

        <div className="w-full">
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <div >
                <h1 className="text-5xl text-center py-2 px-4 border-r border-gray-300">教室列表</h1>
            </div>
            <ul className="">
                <ClassRoom classRooms={classRooms} />
            </ul>
        </div>
    );
}

export default ClassRooms;