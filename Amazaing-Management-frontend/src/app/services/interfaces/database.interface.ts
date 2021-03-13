/**
 * Business Model interface
 */

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

/**
 * Player interface
 */

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

/**
 * Company interface
 */

export interface Company {
    companyId: number,
    companyName: string,
    revenue: number,
    maintenance: number,
    employeesNumber: number,
    accidentRiskIndex: number,
    businessModelId: number,
    playerId: number,
    employees: [
        {
            employeeId: number,
        }
    ]
}

/**
 * Employee interface
 */

export interface Employee{
    employeeId: number,
    employeeName: string,
    photo: string,
    productivity: number,
    clumsiness: number
    companyId: number,
    playerId: number
}
    