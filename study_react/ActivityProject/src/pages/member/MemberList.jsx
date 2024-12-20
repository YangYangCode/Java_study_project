import React, { useState, useEffect } from "react";
import Member_DataTableDataTable from "../../component/Member_DataTable";
import { get_all_fitnessInstructor, get_all_member } from "../../service/Service_AS";
import { Box, Button, Dialog, DialogActions, DialogContent, DialogTitle } from "@mui/material";


function MemberList() {

    // 定義狀態來儲存從 API 獲得的活動資料
    const [members, setMembers] = useState([]);
    useEffect(() => {
        const fetchData = async () => {
            try {
                const members = await get_all_member();
                setMembers(members);  // 將活動資料儲存進狀態
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
                console.log(members);
                
                <Member_DataTableDataTable members={members}  />
            </div>
        </div>



    )
}

export default MemberList;