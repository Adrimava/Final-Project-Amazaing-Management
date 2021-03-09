export interface BusinessModel {
    modelId: number,
    modelName: string,
    photo: string,
    purchasePrice: number,
    maxEmployees: number,
    averageRevenue: number,
    dailyCosts: number,
    employeeSalary: number
}

export interface Player {    
    playerId: number,
    playerName: string,
    money: number,
    photo: string,
    companies: [
        {
            companyId: number,
            companyName: string,
        }
    ],
    employees: [
        {
            employeeId: number,
            employeeName: string
        }
    ]
}
    