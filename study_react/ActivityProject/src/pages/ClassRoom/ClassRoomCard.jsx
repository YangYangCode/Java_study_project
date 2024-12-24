import React, { useEffect, useState } from "react";
import ClassRoom from "../../component/CR_Grid";
import { Link } from "react-router-dom";
import { get_all_bookingList_byType, get_all_classRoom } from "../../service/Service_AS";

function ClassRooms() {

    // 定義狀態來儲存從 API 獲得的活動資料
    const [classRooms, setClassRooms] = useState([]);
    const [allRoomBooking, setAllRoomBooking] = useState([]);

    const classRoomData = async () => {
        try {
            const CRList = await get_all_classRoom();
            setClassRooms(CRList);  // 將活動資料儲存進狀態
        } catch (error) {
            console.error("Error getAllClassRooms:", error);  // 若有錯誤會在這裡處理
        }
    };

    function formatDate(date) {
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0'); // 月份从 0 开始
        const day = String(date.getDate()).padStart(2, '0');
        return `${year}-${month}-${day}`;
    }

    const roomBookingData = async () => {
        try {
            const ListOfBooking = {
                type: "classRoom",
                startDate: formatDate(new Date()), // 初始化为今天的日期
                endDate: formatDate(new Date()),   // 初始化为今天的日期
            }
            console.log(ListOfBooking);

            const CRBbooking = await get_all_bookingList_byType(ListOfBooking);
            setAllRoomBooking(CRBbooking);  // 將活動資料儲存進狀態
        } catch (error) {
            console.error("Error getAllClassRooms:", error);  // 若有錯誤會在這裡處理
        }
    };

    useEffect(() => {
        classRoomData();
        roomBookingData();
    }, []);


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