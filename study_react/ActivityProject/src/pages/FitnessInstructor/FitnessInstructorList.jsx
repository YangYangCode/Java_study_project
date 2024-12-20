import React, { useState, useEffect } from "react";
import FitnDataTable from "../../component/Fitn_DataTable";
import { get_all_fitnessInstructor } from "../../service/Service_AS";
import { Box, Button, Dialog, DialogActions, DialogContent, DialogTitle } from "@mui/material";


function FitnessInstructorList() {

    // 定義狀態來儲存從 API 獲得的活動資料
    const [fitnessInstructors, setFitnessInstructors] = useState([]);
    useEffect(() => {
        const fetchData = async () => {
            try {
                const fitnessInstructors = await get_all_fitnessInstructor();
                setFitnessInstructors(fitnessInstructors);  // 將活動資料儲存進狀態
            } catch (error) {
                console.error("Error fitnessInstructors:", error);  // 若有錯誤會在這裡處理
            }
        };
        fetchData();  // 呼叫 async 函數來取得資料
        // console.log(ActivitiesWithWeekday);  // 注意：ActivitiesWithWeekday 此時不會包含資料
    }, []);  // 空陣列表示只在組件首次渲染時觸發一次




    return (

        <div>
            <br></br>
            <br></br>
            <br></br>
            <br></br>

            {/* DataTable */}
            <div>
                <h1 className="text-6xl text-center font-semibold mb-2">課程清單</h1>
                <FitnDataTable fitnessInstructors={fitnessInstructors}  />
            </div>
        </div>



    )
}

export default FitnessInstructorList;