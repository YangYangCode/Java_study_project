import React, { useState, useEffect } from "react";
import CardItem from "../../component/CT_CardItem";
import { get_all_classType, get_all_fitnessInstructor } from "../../service/Service_AS";
import { Link } from "react-router-dom";

function ClassTypes() {

    // 定義狀態來儲存從 API 獲得的活動資料
    const [classTypes, setClassTypes] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const CTList = await get_all_classType();
                setClassTypes(CTList);  // 將活動資料儲存進狀態
            } catch (error) {
                console.error("Error getClassTypes:", error);  // 若有錯誤會在這裡處理
            }
        };
        fetchData();  // 呼叫 async 函數來取得資料
        // console.log(fitnessInstructors);  // 注意： 此時不會包含資料
    }, []);  // 空陣列表示只在組件首次渲染時觸發一次

    return (

        <div className="w-full">
            <br></br>
            <br></br>
            <br></br>
            <div >
                <h1 className="text-5xl text-center py-2 px-4 border-r border-gray-300">課程列表</h1>
            </div>
            <Link
                to="/addclasstype"
                className="bg-green-500 text-white px-4 py-2 mr-2 rounded-md hover:bg-green-600 hover:underline inline-block text-center "
            >
                新增教室
            </Link>
            <div className="min-h-screen flex justify-center">
                <ul className="w-[90vw] flex justify-center flex-wrap gap-4">
                    {/* 遍歷 fitnessInstructors，為每個教練生成一個 CardItem */}
                    {classTypes.map((instructor, index) => (
                        <CardItem key={index} data={instructor} />
                    ))}
                </ul>
            </div>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
        </div>
    )
}

export default ClassTypes;