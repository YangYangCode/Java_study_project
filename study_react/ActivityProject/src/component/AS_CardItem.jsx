import React from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';

const CardItem = () => {

    // 1. 計算周一至周日
    // 2. 製作Card

    const f_data = [
        {
            id: 1, room: 101, FitnessInstructor: 29, class: "空中瑜珈", numberOfCanRegister: 20, numberOfHaveSigned: 6,
            classTime: "2024,11,19 11-00-00", information: "information", memberHaveSigned: ["1", "2", "3", "4", "5", "6"]
        },
        {
            id: 2, room: 101, FitnessInstructor: 40, class: "飛輪", numberOfCanRegister: 40, numberOfHaveSigned: 10,
            classTime: "2024,10,25 17-00-00", information: "information", memberHaveSigned: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10"]
        },
    ]

    return (
        <li>
                    {/* // 最小寬度 */}
            <Card sx={{ minWidth: 275 }}>
                <CardContent>
                    <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 14 }}>
                        {f_data[0].classTime}
                    </Typography>

                    <Typography variant="h5" component="div">
                    {f_data[0].class}
                    </Typography>

                    
                    <Typography variant="h5" component="div">
                        {f_data[0].FitnessInstructor}
                    </Typography>

                    <Typography sx={{ color: 'text.secondary', mb: 1.5 }}>
                        {f_data[0].memberHaveSigned.length}/{f_data[0].numberOfCanRegister}
                    </Typography>

                    <Typography variant="body2">
                        {f_data[0].room}
                    </Typography>

                </CardContent>
                <CardActions>
                    <Button size="small">information</Button>
                </CardActions>
            </Card>
        </li>
    );
};



export default CardItem;

